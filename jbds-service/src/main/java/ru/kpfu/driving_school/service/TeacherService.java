package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public interface TeacherService {

    List<StudentGroup> getStudentGroups();

    StudentGroup getStudentGroup(Long id);

    List<Student> getStudentsOfStudentGroup(Long id);
}
