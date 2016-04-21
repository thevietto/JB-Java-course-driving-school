package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.form.StudentQuestionForm;
import ru.kpfu.driving_school.model.StudentQuestion;
import ru.kpfu.driving_school.repository.StudentQuestionRepository;
import ru.kpfu.driving_school.service.StudentQuestionService;
import ru.kpfu.driving_school.util.SecurityUtils;

import java.util.List;
import java.util.function.Function;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Service
public class StudentQuestionServiceImpl implements StudentQuestionService {

    @Autowired
    Function<StudentQuestionForm, StudentQuestion> transformer;

    @Autowired
    StudentQuestionRepository studentQuestionRepository;

    @Override
    public void createStudentQuestion(StudentQuestionForm form) {
        studentQuestionRepository.save(transformer.apply(form));
    }

    @Override
    public List<StudentQuestion> getGroupQuestions() {
        return studentQuestionRepository.findByStudentGroupOfCurrentStudent(SecurityUtils.getCurrentUser());
    }

    @Override
    public StudentQuestion getQuestionById(Long id) {
        return studentQuestionRepository.findOne(id);
    }

    @Override
    public List<StudentQuestion> getGroupQuestions(Long id) {
        return studentQuestionRepository.findByStudentGroupId(id);
    }
}
