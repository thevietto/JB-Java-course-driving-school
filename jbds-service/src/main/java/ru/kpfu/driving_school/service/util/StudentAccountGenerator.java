package ru.kpfu.driving_school.service.util;

import ru.kpfu.driving_school.service.form.StudentsForm;
import ru.kpfu.driving_school.model.StudentAccount;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface StudentAccountGenerator {

    List<StudentAccount> generateStudents(StudentsForm studentsForm);

}
