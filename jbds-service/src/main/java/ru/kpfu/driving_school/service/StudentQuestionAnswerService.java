package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.form.StudentQuestionAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
public interface StudentQuestionAnswerService {
    List<StudentQuestionAnswer> getAnswersByQuestion(Long questionId);

    void creteNewAnswer(Long studentQuestionId, StudentQuestionAnswerForm form);
}
