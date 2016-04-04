package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.DrivingSchoolRepository;
import ru.kpfu.driving_school.repository.TeacherRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.TestService;
import ru.kpfu.driving_school.util.SecurityUtils;

import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;
import ru.kpfu.driving_school.model.Task;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.model.enums.TaskStatus;
import ru.kpfu.driving_school.repository.StudentGroupRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.repository.TaskRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.TestService;

import java.util.Date;
import java.util.List;

/**
 * Created by etovladislav on 31.03.16.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    public Long save(String description) {
        Credential currentUser = SecurityUtils.getCurrentUser();
        DrivingSchool drivingSchool = teacherRepository.findOneByCredential(currentUser).getDrivingSchool();
        Test test = new Test();
        test.setDescription(description);
        test.setDrivingSchool(drivingSchool);
        return testRepository.save(test).getId();
    TestRepository testRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Test> getTests(Long groupId) {
        return testRepository.findByGroupId(groupId);
    }

    @Override
    public void createTaskForGroup(Long id, String testName, String description, Date deadline) {
        Test test = testRepository.findOneByDescription(testName);
        StudentGroup studentGroup = studentGroupRepository.findOne(id);
        List<Student> students = studentRepository.findByStudentGroup(studentGroup);
        for (Student student : students) {
            Task task = new Task();
            task.setDeadline(deadline);
            task.setDescription(description);
            task.setTest(test);
            task.setStatus(TaskStatus.NEW);
            task.setStudent(student);
            taskRepository.save(task);
        }
    }
}
