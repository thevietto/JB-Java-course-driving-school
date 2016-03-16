package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.StudentAccount;

import java.util.List;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
public interface DSAdminService {

    void saveStudents(List<StudentAccount> students);

    void changeStudent(Long id);

    void changeStudent(String name);

}
