package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.DrivingSchoolRepository;
import ru.kpfu.driving_school.repository.TeacherRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.TestService;
import ru.kpfu.driving_school.util.SecurityUtils;

/**
 * Created by etovladislav on 31.03.16.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TestRepository testRepository;

    @Override
    public Long save(String description) {
        Credential currentUser = SecurityUtils.getCurrentUser();
        DrivingSchool drivingSchool = teacherRepository.findOneByCredential(currentUser).getDrivingSchool();
        Test test = new Test();
        test.setDescription(description);
        test.setDrivingSchool(drivingSchool);
        return testRepository.save(test).getId();
    }
}
