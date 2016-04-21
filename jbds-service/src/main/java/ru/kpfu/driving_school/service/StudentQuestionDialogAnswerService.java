package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.form.StudentQuestionDialogAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionDialogAnswer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
public interface StudentQuestionDialogAnswerService {
    List<StudentQuestionDialogAnswer> getAnswersByQuestion(Long questionId);

    void creteNewAnswer(Long studentQuestionId, StudentQuestionDialogAnswerForm form);
}
