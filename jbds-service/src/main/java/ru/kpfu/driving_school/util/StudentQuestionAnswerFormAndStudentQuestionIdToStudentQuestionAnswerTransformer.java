package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentQuestionDialogAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionDialogAnswer;
import ru.kpfu.driving_school.repository.StudentQuestionRepository;

import java.util.function.BiFunction;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Component
public class StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer
        implements BiFunction<StudentQuestionDialogAnswerForm, Long, StudentQuestionDialogAnswer> {

    @Autowired
    StudentQuestionRepository studentQuestionRepository;

    @Override
    public StudentQuestionDialogAnswer apply(StudentQuestionDialogAnswerForm form, Long studentQuestionId) {
        StudentQuestionDialogAnswer answer = new StudentQuestionDialogAnswer();
        answer.setStudentQuestion(studentQuestionRepository.findOne(studentQuestionId));
        answer.setCredential(SecurityUtils.getCurrentUser());
        answer.setAnswer(form.getAnswer());
        return answer;
    }
}
