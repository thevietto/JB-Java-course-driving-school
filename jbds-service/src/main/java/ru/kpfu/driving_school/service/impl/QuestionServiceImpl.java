package ru.kpfu.driving_school.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.utils.JpaClassUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.QuestionForm;
import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.model.RightAnswer;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.AnswerVariantRepository;
import ru.kpfu.driving_school.repository.CategoryRepository;
import ru.kpfu.driving_school.repository.QuestionRepository;
import ru.kpfu.driving_school.repository.TestRepository;
import ru.kpfu.driving_school.service.QuestionService;
import ru.kpfu.driving_school.util.PropertyPath;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by etovladislav on 02.04.16.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    AnswerVariantRepository answerVariantRepository;

    @Override
    @Transactional
    public void saveQuestion(QuestionForm questionForm, Long testId) {
        Question question = new Question();
        question.setCategory(categoryRepository.findOne(questionForm.getCategoryId()));
        question.setTest(testRepository.findOne(testId));
        question.setText(questionForm.getText());
        List<AnswerVariant> answerVariants = new ArrayList<>();
        for (String text: questionForm.getAnswerVariantForm()) {
            AnswerVariant answerVariant = new AnswerVariant();
            answerVariant.setText(text);
            answerVariant.setQuestion(question);
            answerVariants.add(answerVariant);
        }
        RightAnswer rightAnswer = new RightAnswer();
        rightAnswer.setAnswerVariant(answerVariants.get(questionForm.getIsRight()));
        question.setAnswerVariants(answerVariants);

        String newFileName = null;
        MultipartFile file = questionForm.getMultipartFile();
        File dir = null;
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                dir = new File(PropertyPath.getPath() + File.separator + "question_images");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                newFileName = UUID.randomUUID().toString() + "."
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + newFileName);
                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        question.setImage("/images/question_images/" + newFileName);
        rightAnswer.setQuestion(question);
        question.setRightAnswer(rightAnswer);
        try {
            questionRepository.save(question);
        } catch (Throwable t) {
            File file1 = new File(newFileName);
            file1.delete();
            throw t;
        }
    }

    @Override
    @Transactional
    public List<Question> getQuestions(Long testId) {
        Test test = testRepository.findOne(testId);
        test.getQuestions().size();
        List<Question> questions = test.getQuestions();
        return questions;
    }
}
