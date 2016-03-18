package ru.kpfu.driving_school.service.util;

import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.service.form.StudentForm;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface StudentAccountGenerator {

    StudentAccount generateStudent(StudentForm form);

}
