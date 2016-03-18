package ru.kpfu.driving_school.util.impl;

import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentsForm;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.util.StudentAccountGenerator;

import java.util.List;
import java.util.Random;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Component
public class StudentAccountGeneratorImpl implements StudentAccountGenerator {

    private final String validChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

    @Override
    public List<StudentAccount> generateStudents(StudentsForm studentsForm) {
        return null;
    }

    private String passwordGen() {
        String s = "";
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            s += validChars.charAt(generator.nextInt(validChars.length()));
        }
        return s;
    }
}
