package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.form.StudentQuestionDialogAnswerForm;
import ru.kpfu.driving_school.model.StudentQuestionDialogAnswer;
import ru.kpfu.driving_school.repository.StudentQuestionDialogAnswerRepository;
import ru.kpfu.driving_school.service.StudentQuestionDialogAnswerService;
import ru.kpfu.driving_school.util.StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Service
public class StudentQuestionDialogAnswerServiceImpl implements StudentQuestionDialogAnswerService {

    @Autowired
    StudentQuestionDialogAnswerRepository studentQuestionDialogAnswerRepository;

    @Autowired
    StudentQuestionAnswerFormAndStudentQuestionIdToStudentQuestionAnswerTransformer transformer;

    @Override
    public List<StudentQuestionDialogAnswer> getAnswersByQuestion(Long questionId) {
        return studentQuestionDialogAnswerRepository.findByStudentQuestionId(questionId);
    }

    @Override
    public void creteNewAnswer(Long studentQuestionId, StudentQuestionDialogAnswerForm form) {
        StudentQuestionDialogAnswer answer = transformer.apply(form, studentQuestionId);
        studentQuestionDialogAnswerRepository.save(answer);
    }
}
