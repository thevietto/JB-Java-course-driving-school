package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface DSAdminService {

    void addStudents(List<StudentAccount> students);

    void deleteStudent(Long id);

    void deleteStudent(String fio);

    void deleteStudent(StudentAccount student);

    void saveNewStudent(StudentForm form);

}
