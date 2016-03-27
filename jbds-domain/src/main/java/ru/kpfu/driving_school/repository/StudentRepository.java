package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.StudentAccount;

import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentAccount, Long> {

    @Query(value = "SELECT s.id FROM student s JOIN student_group sg ON s.student_group_id = sg.id JOIN " +
            " teacher t ON sg.teacher_id = t.id JOIN  driving_school ds ON t.driving_school_id = ds.id" +
            " JOIN ds_admin dsa ON dsa.driving_school_id = ds.id  WHERE s.id = :studentId and dsa.id = :dsadminId ", nativeQuery = true)
    List<Long> isBelong(@Param("studentId") Long studentId, @Param("dsadminId")Long dsAdminId);

    StudentAccount findOneByFio(String fio);
}
