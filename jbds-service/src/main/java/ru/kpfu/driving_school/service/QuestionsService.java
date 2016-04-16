package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Question;

import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
public interface QuestionsService {

    List<Question> getQuestionsByTaskId(Long id);

}
