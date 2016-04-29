package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.AnswerVariant;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;
import ru.kpfu.driving_school.repository.AnswerVariantRepository;
import ru.kpfu.driving_school.repository.StudentQuestionAnswerRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.repository.TaskRepository;
import ru.kpfu.driving_school.service.StudentQuestionAnswersService;
import ru.kpfu.driving_school.util.SecurityUtils;

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

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<StudentQuestionAnswer> saveStudentResults(Long taskId, String studentAnswers) {
        List<StudentQuestionAnswer> studentQuestionAnswers = new ArrayList<>();
        String [] studentAnswersId = studentAnswers.split(" ");

        for (String st : studentAnswersId) {
            AnswerVariant answerVariant = answerVariantRepository.findOne(Long.parseLong(st));
            studentQuestionAnswers.add(new StudentQuestionAnswer(
                    studentRepository.findByCredential(SecurityUtils.getCurrentUser()), //current user
                    taskRepository.findOne(taskId).getTest(),                           //find test by task id
                    answerVariant.getQuestion(),
                    answerVariant));
        }

        studentQuestionAnswerRepository.save(studentQuestionAnswers);

        return studentQuestionAnswers;
    }
}
