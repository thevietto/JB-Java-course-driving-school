package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * Created by aleksandrpliskin on 02.04.16.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
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
