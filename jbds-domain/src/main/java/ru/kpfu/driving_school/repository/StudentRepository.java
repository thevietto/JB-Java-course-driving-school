package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findOneByFio(String fio);

    List<Student> findByStudentGroup(StudentGroup studentGroup);

    Student findByCredential(Credential currentUser);
}
