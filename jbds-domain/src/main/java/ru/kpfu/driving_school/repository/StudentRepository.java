package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.StudentAccount;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentAccount, Long> {

    StudentAccount findOneByFio(String fio);

}
