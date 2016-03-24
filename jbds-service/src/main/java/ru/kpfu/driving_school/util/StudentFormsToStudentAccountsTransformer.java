package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.DSAdminRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by aleksandrpliskin on 25.03.16.
 */
@Component
public class StudentFormsToStudentAccountsTransformer implements Function<List<StudentForm>, List<StudentAccount>> {

    @Autowired
    private DSAdminRepository dsAdminRepository;

    @Autowired
    private StudentAccountGenerator generator;

    @Override
    public List<StudentAccount> apply(List<StudentForm> studentForms) {
        return studentForms.stream().map(this::transformStudentFormToStudentAccount).collect(Collectors.toList());
    }

    private StudentAccount transformStudentFormToStudentAccount(StudentForm form) {
        StudentAccount student = generator.apply(form);
        DrivingSchool drivingSchool = dsAdminRepository.findOneByCredentials(SecurityUtils.getCurrentUser()).getDrivingSchool();
        student.setDrivingSchool(drivingSchool);
        return student;
    }

}