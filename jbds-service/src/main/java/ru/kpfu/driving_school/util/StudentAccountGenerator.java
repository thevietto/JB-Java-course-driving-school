package ru.kpfu.driving_school.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialsRepository;

import java.util.Random;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentAccountGenerator {

    private CredentialsRepository credentialsRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public StudentAccountGenerator(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    @Transactional
    public StudentAccount generateStudent(StudentForm form) {
        String fio = form.getFirstname() + ' ' + form.getSurname() + ' ' + form.getLastname();
        String login = loginGen(form.getFirstname(), form.getSurname(), form.getLastname());
        String password = passwordGen();
        Credentials credentials = new Credentials();
        credentials.setLogin(login);
        credentials.setPassword(encoder.encode(password));
        credentials.setRole(UserRole.ROLE_STUDENT);
        credentialsRepository.save(credentials);
        StudentAccount student = new StudentAccount();
        student.setFio(fio);
        student.setCredentials(credentials);
        return student;
    }

    private String passwordGen() {
        String s = "";
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            s += validChars.charAt(generator.nextInt(validChars.length()));
        }
        return s;
    }

    private String loginGen(String firstname, String surname, String lastname) {
        firstname = translate(firstname);
        surname = translate(surname);
        lastname = translate(lastname);
        String login = "";
        login += surname;
        boolean unique = false;
        boolean firstCharName = false;
        boolean firstCharLastName = false;
        int firstnameIs = 1;
        int lastnameIs = 1;
        while (!unique) {
            if (credentialsRepository.findOneByLogin(login) == null) {
                unique = true;
            } else {
                if (!firstCharName) {
                    login += firstname.charAt(0);
                    firstCharName = true;
                } else if (firstnameIs != firstname.length()) {
                    login += firstname.charAt(firstnameIs);
                    firstnameIs++;
                } else if (!firstCharLastName) {
                    login += lastname.charAt(0);
                    firstCharLastName = true;
                } else if (lastnameIs != lastname.length()) {
                    login += lastname.charAt(lastnameIs);
                    lastnameIs++;
                } else {
                    login += new Random().nextInt(10);
                }
            }
        }
        return login;
    }

    private String translate(String fname) {
        RusToEng translator = new RusToEng();
        String russian = null;
        try {
            russian = translator.translate(fname);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return russian;
    }
}
