package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentEditForm;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialRepository;
import ru.kpfu.driving_school.repository.StudentRepository;

import java.util.function.Function;

@Component
public class StudentAccountTransformer implements Function<StudentEditForm, Student> {

    @Autowired
    CredentialRepository credentialsRepository;

    @Autowired
    StudentRepository studentRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Student apply(StudentEditForm editForm) {
        Credential credentials = new Credential();
        if (editForm.getPassword().length() > 0) {
            credentials.setPassword(encoder.encode(editForm.getPassword()));
        }
        Student studentAccount = new Student();
        studentAccount.setCredentials(credentials);
        studentAccount.setFio(editForm.getFio());
        return studentAccount;
    }
}
