package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.form.StudentQuestionAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;
import ru.kpfu.driving_school.repository.StudentQuestionAnswerRepository;
import ru.kpfu.driving_school.service.StudentQuestionAnswerService;
import ru.kpfu.driving_school.util.StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Service
public class StudentQuestionAnswerServiceImpl implements StudentQuestionAnswerService {

    @Autowired
    StudentQuestionAnswerRepository studentQuestionAnswerRepository;

    @Autowired
    StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer transformer;

    @Override
    public List<StudentQuestionAnswer> getAnswersByQuestion(Long questionId) {
        return studentQuestionAnswerRepository.findByStudentQuestionId(questionId);
    }

    @Override
    public void creteNewAnswer(Long studentQuestionId, StudentQuestionAnswerForm form) {
        StudentQuestionAnswer answer = transformer.apply(form,studentQuestionId);
        studentQuestionAnswerRepository.save(answer);
    }
}
