package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Question;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
public interface AnswerVariantService {

    HashMap<String, List<AnswerVariant>> getAnswerVariantsByQuestions(List<Question> questions);

    AnswerVariant findOne(Long id);



}
