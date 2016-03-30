package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentPoint;
import ru.kpfu.driving_school.model.enums.Marks;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public interface StudentService {

    Student getStudent(Long id);

    List<StudentPoint> getStudentPoints(Long studentId);

    void setStudentPoints(Long studentId, String description, String mark);
}
