package ru.kpfu.driving_school.util.impl;

import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.util.StudentAccountGenerator;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentsFormToStudentsTransformer {

    private static StudentAccountGenerator generator = new StudentAccountGeneratorImpl();

    public static StudentAccount transform(StudentForm form) {
        return generator.generateStudent(form);
    }


}
