package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentQuestionAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;
import ru.kpfu.driving_school.repository.StudentQuestionRepository;

import java.util.function.BiFunction;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Component
public class StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer
        implements BiFunction<StudentQuestionAnswerForm, Long, StudentQuestionAnswer> {

    @Autowired
    StudentQuestionRepository studentQuestionRepository;

    @Override
    public StudentQuestionAnswer apply(StudentQuestionAnswerForm form, Long studentQuestionId) {
        StudentQuestionAnswer answer = new StudentQuestionAnswer();
        answer.setStudentQuestion(studentQuestionRepository.findOne(studentQuestionId));
        answer.setCredential(SecurityUtils.getCurrentUser());
        answer.setAnswer(form.getAnswer());
        return answer;
    }
}
