package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.StudentMark;

import java.util.List;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Repository
public interface StudentMarkRepository extends JpaRepository<StudentMark, Long> {

    List<StudentMark> findByStudent(Student student);

}
