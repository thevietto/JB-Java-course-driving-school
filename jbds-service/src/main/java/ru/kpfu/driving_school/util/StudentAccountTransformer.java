package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentEditForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialsRepository;
import ru.kpfu.driving_school.repository.StudentRepository;

import java.util.function.Function;

@Component
public class StudentAccountTransformer implements Function<StudentEditForm, StudentAccount> {

    @Autowired
    CredentialsRepository credentialsRepository;

    @Autowired
    StudentRepository studentRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public StudentAccount apply(StudentEditForm editForm) {
        Credentials credentials = new Credentials();
        if (editForm.getPassword().length() > 0) {
            credentials.setPassword(encoder.encode(editForm.getPassword()));
        }
        StudentAccount studentAccount = new StudentAccount();
        studentAccount.setCredentials(credentials);
        studentAccount.setFio(editForm.getFio());
        return studentAccount;
    }
}
