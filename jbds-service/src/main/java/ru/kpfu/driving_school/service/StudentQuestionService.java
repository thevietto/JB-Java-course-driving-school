package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.form.StudentQuestionForm;
import ru.kpfu.driving_school.model.StudentQuestion;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
public interface StudentQuestionService {

    void createStudentQuestion(StudentQuestionForm form);

    List<StudentQuestion> getGroupQuestions();

    StudentQuestion getQuestionById(Long id);

    List<StudentQuestion> getGroupQuestions(Long id);
}
