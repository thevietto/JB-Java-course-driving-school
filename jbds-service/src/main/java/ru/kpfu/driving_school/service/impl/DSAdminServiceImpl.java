package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.PlainRepository;
import ru.kpfu.driving_school.service.DSAdminService;

import java.util.List;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
public class DSAdminServiceImpl implements DSAdminService {

    @Autowired
    PlainRepository plainRepository;

    @Override
    public void saveStudents(List<StudentAccount> students) {
        students.forEach(plainRepository::save);
    }


    @Override
    public void changeStudent(Long id) {

    }

    @Override
    public void changeStudent(String name) {

    }
}
