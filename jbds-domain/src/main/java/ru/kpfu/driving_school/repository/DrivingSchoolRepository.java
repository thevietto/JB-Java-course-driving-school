package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.driving_school.model.DrivingSchool;

/**
 * Created by aleksandrpliskin on 21.03.16.
 */
public interface DrivingSchoolRepository extends JpaRepository<DrivingSchool, Long>{

    DrivingSchool findOneByName(String name);

}
