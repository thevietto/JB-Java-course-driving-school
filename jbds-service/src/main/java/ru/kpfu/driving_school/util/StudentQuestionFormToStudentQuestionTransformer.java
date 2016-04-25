package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentQuestionForm;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentQuestion;
import ru.kpfu.driving_school.repository.StudentRepository;

import java.util.function.Function;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Component
public class StudentQuestionFormToStudentQuestionTransformer implements Function<StudentQuestionForm, StudentQuestion> {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public StudentQuestion apply(StudentQuestionForm form) {
        StudentQuestion question = new StudentQuestion();
        question.setQuestion(form.getQuestion());
        Student student = studentRepository.findByCredential(SecurityUtils.getCurrentUser());
        question.setStudent(student);
        return question;
    }
}
