package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.GroupTest;
import ru.kpfu.driving_school.model.StudentGroup;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.GroupTestRepository;
import ru.kpfu.driving_school.repository.StudentGroupRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.TestService;

import java.util.List;

/**
 * Created by aleksandrpliskin on 02.04.16.
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    GroupTestRepository groupTestRepository;

    @Override
    public List<Test> getTests(Long groupId) {
        return testRepository.findByGroupId(groupId);
    }

    @Override
    public void createGroupTest(Long id, String testName, String description) {
        Test test = testRepository.findOneByDescription(testName);
        StudentGroup studentGroup = studentGroupRepository.findOne(id);
        GroupTest groupTest = new GroupTest();
        groupTest.setDescription(description);
        groupTest.setTest(test);
        groupTest.setStudentGroup(studentGroup);
        groupTestRepository.save(groupTest);
    }
}
