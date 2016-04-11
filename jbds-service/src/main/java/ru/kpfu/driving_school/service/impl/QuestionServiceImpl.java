package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.driving_school.form.QuestionForm;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.QuestionRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.QuestionService;

import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by etovladislav on 02.04.16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    BiFunction<QuestionForm, Long, Question> questionBiFunction;

    @Override
    @Transactional
    public void saveQuestion(QuestionForm questionForm, Long testId) {
        Question question = questionBiFunction.apply(questionForm, testId);
        questionRepository.save(question);
    }

    @Override
    @Transactional
    public List<Question> getQuestions(Long testId) {
        Test test = testRepository.findOne(testId);
        test.getQuestions().size();
        List<Question> questions = test.getQuestions();
        return questions;
    }

    @Override
    @Transactional
    public Question findQuestionById(Long questionId) {
        Question question = questionRepository.findQuestionById(questionId);
        question.getAnswerVariants().size();
        return question;
    }
}
