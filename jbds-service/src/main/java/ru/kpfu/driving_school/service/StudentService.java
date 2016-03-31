package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentMark;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public interface StudentService {

    Student getStudent(Long id);

    List<StudentMark> getStudentMarks(Long studentId);

    void setStudentMarks(Long studentId, String description, String mark);
}
