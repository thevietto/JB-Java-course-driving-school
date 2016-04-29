package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Task;

/**
 * Created by Azat Zaripov on 11.04.16.
 */
public interface TaskService {
    Task findOne(Long id);
}
