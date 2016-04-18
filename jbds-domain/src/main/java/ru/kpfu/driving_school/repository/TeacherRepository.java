package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.Teacher;
import ru.kpfu.driving_school.model.Test;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Teacher findOneByFio(String fio);

    Teacher findOneByCredential(Credential credential);
}
