package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.DSAdmin;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;
import ru.kpfu.driving_school.repository.*;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.util.ExcelStudentParser;
import ru.kpfu.driving_school.util.SecurityUtils;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Service
public class DSAdminServiceImpl implements DSAdminService {

    @Autowired
    private DSAdminRepository dsAdminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private Function<StudentForm, Student> generator;

    @Autowired
    private Function<DSAccountForm, DSAdmin> transformer;

    @Autowired
    private ExcelStudentParser excelStudentParser;

    @Override
    public void addStudents(List<Student> students) {
        studentRepository.save(students);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void deleteStudent(String fio) {
        studentRepository.delete(studentRepository.findOneByFio(fio));
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    @Override
    public void saveNewStudent(StudentForm form) {
        Student student = generator.apply(form);
        studentRepository.save(student);
    }

    @Override
    public void createDSAccount(DSAccountForm dsAccountForm) {
        DSAdmin dsAdmin = transformer.apply(dsAccountForm);
        DrivingSchool drivingSchool = drivingSchoolRepository.findOne(dsAccountForm.getDrivingSchoolId());
        dsAdmin.setDrivingSchool(drivingSchool);
        dsAdminRepository.save(dsAdmin);
    }

    @Override
    public List<StudentGroup> getStudentGroups() {
        return studentGroupRepository.findByDrivingSchool(SecurityUtils.getCurrentUser().getId());
    }

    @Override
    @Transactional
    public void createStudentGroup(String teacherName, MultipartFile file) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setTeacher(teacherRepository.findOneByFio(teacherName));
        studentGroup.setDrivingSchool(teacherRepository.findOneByFio(teacherName).getDrivingSchool());
        try {
            List<Student> students = excelStudentParser.parse(file).stream().map(generator).collect(Collectors.toList());
            for (Student studentAccount : students) {
                studentAccount.setStudentGroup(studentGroup);
            }
            studentGroup.setStudents(students);
            studentGroupRepository.save(studentGroup);
            studentRepository.save(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        Student oldStudent = studentRepository.findOne(student.getId());
        oldStudent.setFio(student.getFio());
        if (student.getCredentials().getPassword() != null) {
            oldStudent.getCredentials().setPassword(student.getCredentials().getPassword());
        }
        studentRepository.save(oldStudent);
    }


}
