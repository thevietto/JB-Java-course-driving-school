package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.DSAdminRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.util.impl.StudentsFormToStudentsTransformer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Service
public class DSAdminServiceImpl implements DSAdminService {

    @Autowired
    private DSAdminRepository dsAdminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addStudents(List<StudentAccount> students) {
        studentRepository.save(students);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void deleteStudent(String fio) {
        studentRepository.delete(studentRepository.findOneByFio(fio));
    }

    @Override
    public void deleteStudent(StudentAccount student) {
        studentRepository.delete(student);
    }

    @Override
    @Transactional
    public void saveNewStudent(StudentForm form) {
        StudentAccount student = StudentsFormToStudentsTransformer.transform(form);
        studentRepository.save(student);
    }
}
