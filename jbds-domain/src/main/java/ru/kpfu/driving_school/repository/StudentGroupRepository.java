package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 24.03.16.
 */
@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {

    @Query(
            value =
                    "SELECT student_group.id,student_group.driving_school_id,teacher_id " +
                            "FROM driving_school INNER JOIN student_group ON driving_school.id = student_group.driving_school_id " +
                            "WHERE driving_school_id = " +
                            "(SELECT driving_school_id FROM ds_admin INNER JOIN credential " +
                            "ON ds_admin.credential_id = credential.id " +
                            "WHERE credential.id = :credentialId)",
            nativeQuery = true)
    List<StudentGroup> findByDrivingSchool(@Param("credentialId") Long credentialId);
}
