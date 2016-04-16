package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;
import ru.kpfu.driving_school.model.Test;
import ru.kpfu.driving_school.repository.AnswerVariantRepository;
import ru.kpfu.driving_school.repository.StudentQuestionAnswerRepository;
import ru.kpfu.driving_school.service.StudentQuestionAnswersService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azat Zaripov on 08.04.16.
 */
@Service
public class StudentQuestionAnswersServiceImpl implements StudentQuestionAnswersService {

    @Autowired
    AnswerVariantRepository answerVariantRepository;

    @Autowired
    StudentQuestionAnswerRepository studentQuestionAnswerRepository;

    @Override
    public List<StudentQuestionAnswer> saveStudentResults(Student student, Test test, List<AnswerVariant> answers) {
        List<StudentQuestionAnswer> studentQuestionAnswers = new ArrayList<>();
        try{
            for (AnswerVariant answerVariant : answers) {
                StudentQuestionAnswer answer = new StudentQuestionAnswer();
                answer.setTest(test);
                answer.setStudent(student);
                answer.setAnswerVariant(answerVariant);
                answer.setQuestion(answerVariant.getQuestion());
                studentQuestionAnswers.add(answer);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        studentQuestionAnswerRepository.save(studentQuestionAnswers);

        return studentQuestionAnswers;
    }
}
