package ru.kpfu.driving_school.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.service.DSAdminService;

import java.util.List;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Service
public class DSAdminServiceImpl implements DSAdminService {

//    @Autowired
//    PlainRepository plainRepository;

    @Override
    public void saveStudents(List<StudentAccount> students) {
//        students.forEach(plainRepository::save);
    }


    @Override
    public void changeStudent(Long id) {

    }

    @Override
    public void changeStudent(String name) {

    }
}
