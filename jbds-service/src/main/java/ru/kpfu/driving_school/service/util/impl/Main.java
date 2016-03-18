package ru.kpfu.driving_school.service.util.impl;

import ru.kpfu.driving_school.service.form.StudentForm;
import ru.kpfu.driving_school.service.util.StudentAccountGenerator;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class Main {
    public static void main(String[] args) {
        StudentAccountGenerator generator = new StudentAccountGeneratorImpl();
        StudentForm form = new StudentForm();
        form.setFirstname("Плискин");
        form.setSurname("Александр");
        form.setLastname("Маркович");
        generator.generateStudent(form);
    }
}
