package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.*;
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
    private Function<StudentForm, StudentAccount> generator;

    @Autowired
    private Function<DSAccountForm, DSAdminAccount> transformer;

    @Autowired
    private ExcelStudentParser excelStudentParser;

    @Override
    public void addStudents(List<StudentAccount> students) {
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
    public void deleteStudent(StudentAccount student) {
        studentRepository.delete(student);
    }

    @Override
    public void saveNewStudent(StudentForm form) {
        StudentAccount student = generator.apply(form);
        studentRepository.save(student);
    }

    @Override
    public void createDSAccount(DSAccountForm dsAccountForm) {
        DSAdminAccount dsAdmin = transformer.apply(dsAccountForm);
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
        studentGroup.setTeacherAccount(teacherRepository.findOneByFio(teacherName));
        studentGroup.setDrivingSchool(teacherRepository.findOneByFio(teacherName).getDrivingSchool());
        try {
            List<StudentAccount> students = excelStudentParser.parse(file).stream().map(generator).collect(Collectors.toList());
            for (StudentAccount studentAccount : students) {
                studentAccount.setStudentGroup(studentGroup);
            }
            studentGroup.setStudentAccountList(students);
            studentGroupRepository.save(studentGroup);
            studentRepository.save(students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveStundetChange(StudentAccount student) {
        StudentAccount oldStudent = studentRepository.findOne(student.getId());
        if (isBelong(student.getId())) {
            oldStudent.setFio(student.getFio());
            oldStudent.getCredentials().setLogin(student.getCredentials().getLogin());
            if (student.getCredentials().getPassword().trim().length() != 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                oldStudent.getCredentials().setPassword(encoder.encode(student.getCredentials().getPassword()));
            }
        }
        studentRepository.save(oldStudent);
    }

    @Override
    public boolean isBelong(Long studentId) {
        Credentials credentials = (Credentials) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        DSAdminAccount DSAdmin = dsAdminRepository.findOneByCredentials(credentials);
        if (studentRepository.isBelong(studentId, DSAdmin.getId()).size() > 0) {
            return true;
        }
        return false;
    }


}
