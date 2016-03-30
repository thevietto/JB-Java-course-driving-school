package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.exception.NoSuchStudentException;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentMark;
import ru.kpfu.driving_school.model.enums.Marks;
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
        try {
            return studentRepository.findOne(id);
        } catch (NullPointerException e) {
            throw new NoSuchStudentException();
        }
    }

    @Override
    public List<StudentMark> getStudentPoints(Long studentId) {
        try {
            return studentMarkRepository.findByStudent(studentRepository.findOne(studentId));
        } catch (NullPointerException e) {
            throw new NoSuchStudentException();
        }
    }

    @Override
    public void setStudentPoints(Long studentId, String description, String mark) {
        try {
            StudentMark studentPoint = new StudentMark();
            studentPoint.setStudent(studentRepository.findOne(studentId));
            studentPoint.setDescription(description);
            studentPoint.setMarks(Marks.valueOf(mark.toUpperCase()));
            studentPoint.setCreatedAt(new Date());
            studentMarkRepository.save(studentPoint);
        } catch (NullPointerException e) {
            throw new NoSuchStudentException();
        }
    }


}
