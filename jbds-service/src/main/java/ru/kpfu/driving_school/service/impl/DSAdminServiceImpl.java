package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.DSAdminRepository;
import ru.kpfu.driving_school.repository.DrivingSchoolRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.util.SecurityUtils;

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
    private DrivingSchoolRepository drivingSchoolRepository;

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
    public void saveNewStudent(StudentForm form) {
        StudentAccount student = generator.apply(form);
        DrivingSchool drivingSchool = dsAdminRepository.findOneByCredentials(SecurityUtils.getCurrentUser()).getDrivingSchool();
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
