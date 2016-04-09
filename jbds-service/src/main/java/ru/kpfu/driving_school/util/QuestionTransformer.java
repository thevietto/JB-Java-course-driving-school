package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.QuestionForm;
import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Question;
import ru.kpfu.driving_school.model.RightAnswer;
import ru.kpfu.driving_school.repository.CategoryRepository;
import ru.kpfu.driving_school.repository.TestRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * Created by etovladislav on 09.04.16.
 */
@Component
public class QuestionTransformer implements BiFunction<QuestionForm, Long, Question> {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TestRepository testRepository;


    @Override
    public Question apply(QuestionForm questionForm, Long testId) {
        Question question = new Question();
        question.setCategory(categoryRepository.findOne(questionForm.getCategoryId()));
        question.setTest(testRepository.findOne(testId));
        question.setText(questionForm.getText());

        List<AnswerVariant> answerVariants = new ArrayList<>();
        for (String text : questionForm.getAnswerVariantForm()) {
            AnswerVariant answerVariant = new AnswerVariant();
            answerVariant.setText(text);
            answerVariant.setQuestion(question);
            answerVariants.add(answerVariant);
        }
        RightAnswer rightAnswer = new RightAnswer();
        rightAnswer.setAnswerVariant(answerVariants.get(questionForm.getRightAnswer()));
        question.setAnswerVariants(answerVariants);

        MultipartFile file = questionForm.getMultipartFile();
        ImageUpload imageUpload = new ImageUpload();
        String newFileName = imageUpload.upload(file, PropertyPath.questionImageDir);
        question.setImage("/images/question_images/" + newFileName);

        rightAnswer.setQuestion(question);
        question.setRightAnswer(rightAnswer);

        return question;
    }
}
