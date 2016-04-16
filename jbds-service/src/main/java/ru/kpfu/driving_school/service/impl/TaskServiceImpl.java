package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Task;
import ru.kpfu.driving_school.repository.TaskRepository;
import ru.kpfu.driving_school.service.TaskService;

/**
 * Created by Azat Zaripov on 11.04.16.
 */
@Service
public class TaskServiceImpl implements TaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task findOne(Long id) {
        return taskRepository.findById(id);
    }
}
