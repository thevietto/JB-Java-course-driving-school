package ru.kpfu.driving_school.util;

import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface StudentAccountGenerator {

    StudentAccount generateStudent(StudentForm form);

}
