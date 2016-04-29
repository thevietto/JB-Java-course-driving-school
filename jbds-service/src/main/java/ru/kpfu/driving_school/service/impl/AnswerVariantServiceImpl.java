package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.repository.AnswerVariantRepository;
import ru.kpfu.driving_school.service.AnswerVariantService;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
@Service
public class AnswerVariantServiceImpl implements AnswerVariantService{
    @Autowired
    AnswerVariantRepository answerVariantRepository;

    @Override
    public HashMap<String, List<AnswerVariant>> getAnswerVariantsByQuestions(List<Question> questions) {
        HashMap answers = new HashMap<String, List<AnswerVariant>>();
        questions.stream().forEach(q -> answers.put(q.getId().toString(), q.getAnswerVariants()));
        return answers;
    }

    @Override
    public AnswerVariant findOne(Long id) {
        return answerVariantRepository.findOne(id);
    }
}
