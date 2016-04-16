package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.model.Task;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.TaskRepository;
import ru.kpfu.driving_school.service.QuestionsService;

import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
@Service
public class QuestionServiceImpl implements QuestionsService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    @Transactional
    public List<Question> getQuestionsByTaskId(Long id) {
        Task task = taskRepository.findById(id);
        Test test = task.getTest();
        test.getQuestions().size();
        return test.getQuestions();
    }
}
