package ru.kpfu.driving_school.util;

import ru.kpfu.driving_school.form.StudentsForm;
import ru.kpfu.driving_school.model.StudentAccount;

import java.util.List;
import java.util.Properties;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface StudentAccountGenerator {

    List<StudentAccount> generateStudents(StudentsForm studentsForm);

}
