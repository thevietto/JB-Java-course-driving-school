package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Student;
import ru.kpfu.driving_school.model.Task;

import java.util.List;

/**
 * Created by aleksandrpliskin on 02.04.16.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStudent(Student student);

    Task findById(Long id);
}
