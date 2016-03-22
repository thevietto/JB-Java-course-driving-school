package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.*;
import ru.kpfu.driving_school.service.DSAdminService;

import java.util.List;
import java.util.function.Function;

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
    private CredentialsRepository credentialsRepository;

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private SystemAdminRepository systemAdminRepository;

    @Autowired
    private Function<StudentForm, StudentAccount> generator;

    @Autowired
    private Function<DSAccountForm, DSAdminAccount> transformer;

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
    public void saveNewStudent(StudentForm form, Credentials credentials) {
        StudentAccount student = generator.apply(form);
        StudentAccount studentAccount = studentRepository.findOneByFio("Ivan Ivanov Ivanovich");
        DrivingSchool drivingSchool = dsAdminRepository.findOneByCredentials(credentials).getDrivingSchool();//TODO
//        DrivingSchool drivingSchool = dsAdminRepository.findOneById(1L).getDrivingSchool();
        student.setDrivingSchool(drivingSchool);
        studentRepository.save(student);
    }

    @Override
    public void createDSAccount(DSAccountForm dsAccountForm, Credentials credentials, Long id) {
        DSAdminAccount dsAdmin = transformer.apply(dsAccountForm);
        DrivingSchool drivingSchool = drivingSchoolRepository.findOne(id);
        dsAdmin.setDrivingSchool(drivingSchool);
        dsAdminRepository.save(dsAdmin);
    }
}
