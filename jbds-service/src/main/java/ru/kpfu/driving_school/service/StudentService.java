package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.StudentAccount;

/**
 * Created by mikl on 27.03.2016.
 */

public interface StudentService {
    StudentAccount findOneById(Long id);

}
