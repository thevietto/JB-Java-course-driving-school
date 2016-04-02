package ru.kpfu.driving_school.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.service.QuestionService;

import java.util.List;

/**
 * Created by etovladislav on 02.04.16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Override
    public void saveQuestion() {

    }

    @Override
    public List<Question> getQuestions(Long testId) {
        return null;
    }
}
