package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.StudentPoint;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Repository
public interface StudentPointRepository extends JpaRepository<StudentPoint, Long> {
}
