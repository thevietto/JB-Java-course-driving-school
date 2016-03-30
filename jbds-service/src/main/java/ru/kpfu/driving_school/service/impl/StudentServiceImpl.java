package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentPoint;
import ru.kpfu.driving_school.model.enums.Marks;
import ru.kpfu.driving_school.repository.StudentPointRepository;
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
    StudentPointRepository studentPointRepository;

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findOne(id);
    }

    @Override
    public List<StudentPoint> getStudentPoints(Long studentId) {
        return studentPointRepository.findByStudent(studentRepository.findOne(studentId));
    }

    @Override
    public void setStudentPoints(Long studentId, String description, String mark) {
        StudentPoint studentPoint = new StudentPoint();
        studentPoint.setStudent(studentRepository.findOne(studentId));
        studentPoint.setDescription(description);
        studentPoint.setMarks(Marks.valueOf(mark.toUpperCase()));
        studentPoint.setDate(new Date());
        studentPointRepository.save(studentPoint);
    }


}
