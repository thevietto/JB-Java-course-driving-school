package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.StudentQuestionAnswer;

import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
public interface StudentQuestionAnswersService {

    List<StudentQuestionAnswer> saveStudentResults(Long taskId, String studentAnswers);

}
