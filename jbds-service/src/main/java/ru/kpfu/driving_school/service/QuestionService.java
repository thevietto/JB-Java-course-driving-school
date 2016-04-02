package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Question;

import java.util.List;

/**
 * Created by etovladislav on 01.04.16.
 */
public interface QuestionService {

    void saveQuestion();

    List<Question> getQuestions(Long testId);
}
