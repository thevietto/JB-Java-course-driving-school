package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.exception.NoMarksForSuchStudentException;
import ru.kpfu.driving_school.exception.NoSuchStudentException;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentMark;
import ru.kpfu.driving_school.repository.StudentMarkRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMarkRepository studentMarkRepository;

    @Override
    public Student getStudent(Long id) {
        Student student = studentRepository.findOne(id);
        if (student == null) {
            throw new NoSuchStudentException();
        }
        return student;
    }

    @Override
    public List<StudentMark> getStudentMarks(Long studentId) {
        Student student = getStudent(studentId);
        List<StudentMark> studentMarks = studentMarkRepository.findByStudent(student);
        if (studentMarks == null) {
            throw new NoMarksForSuchStudentException();
        }
        return studentMarks;
    }

    @Override
    public void setStudentMarks(Long studentId, String description, String mark) {
        StudentMark studentPoint = new StudentMark();
        studentPoint.setStudent(getStudent(studentId));
        studentPoint.setDescription(description);
        studentPoint.setMark(Integer.parseInt(mark));
        studentPoint.setCreatedAt(new Date());
        studentMarkRepository.save(studentPoint);
    }
}

