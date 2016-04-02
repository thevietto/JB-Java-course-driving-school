package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Test;

import java.util.List;

/**
 * Created by aleksandrpliskin on 02.04.16.
 */
public interface TestService {

    List<Test> getTests(Long groupId);

}
