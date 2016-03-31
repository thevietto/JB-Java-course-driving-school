package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.exception.NoGroupForTeacherException;
import ru.kpfu.driving_school.exception.NoSuchStudentGroupException;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;
import ru.kpfu.driving_school.repository.StudentGroupRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.TeacherService;
import ru.kpfu.driving_school.util.SecurityUtils;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    StudentGroupRepository studentGroupRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<StudentGroup> getStudentGroups() {
        List<StudentGroup> groupList = studentGroupRepository.findByTeacher(SecurityUtils.getCurrentUser());
        if (groupList == null) {
            throw new NoGroupForTeacherException();
        }
        return groupList;
    }


    @Override
    public StudentGroup getStudentGroup(Long id) {
        StudentGroup studentGroup = studentGroupRepository.findOne(id);
        if (studentGroup == null) {
            throw new NoSuchStudentGroupException();
        }
        return studentGroup;
    }


    @Override
    public List<Student> getStudentsOfStudentGroup(Long id) {
        StudentGroup studentGroup = studentGroupRepository.findOne(id);
        if (studentGroup == null) {
            throw new NoSuchStudentGroupException();
        }
        return studentRepository.findByStudentGroup(studentGroup);
    }
}


