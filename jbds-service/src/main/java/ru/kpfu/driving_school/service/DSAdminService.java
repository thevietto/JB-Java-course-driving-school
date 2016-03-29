package ru.kpfu.driving_school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public interface DSAdminService {

    void addStudents(List<Student> students);

    void deleteStudent(Long id);

    void deleteStudent(String fio);

    void deleteStudent(Student student);

    void saveNewStudent(StudentForm form);

    void createDSAccount(DSAccountForm dsAccountForm);

    List<StudentGroup> getStudentGroups();

    void createStudentGroup(String teacherName, MultipartFile file);
}
