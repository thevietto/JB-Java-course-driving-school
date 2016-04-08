package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by etovladislav on 31.03.16.
 */
public interface TestService {

    Long save(String description);

    List<Test> getTests(Long groupId);

    void createTaskForGroup(Long id, String testName, String description, Date deadline);

    List<Test> getDSTests();

}
