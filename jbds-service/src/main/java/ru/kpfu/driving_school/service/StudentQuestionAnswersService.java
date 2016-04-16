package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;
import ru.kpfu.driving_school.model.Test;

import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
public interface StudentQuestionAnswersService {

    List<StudentQuestionAnswer> saveStudentResults(Student student, Test test, List<AnswerVariant> answers);

}
