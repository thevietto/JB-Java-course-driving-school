package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
    @Modifying
    @Query(
            value = "SELECT\n" +
                    "  student_group.id,\n" +
                    "  student_group.driving_school_id,\n" +
                    "  student_group.teacher_id\n" +
                    "FROM student_group\n" +
                    "  JOIN driving_school ON student_group.driving_school_id = driving_school.id\n" +
                    "  JOIN ds_admin ON ds_admin.driving_school_id = driving_school.id\n" +
                    "WHERE ds_admin.credential_id = :credentialId",
            nativeQuery = true)
//    @Query(value = "select StudentGroup sg from sg inner join DrivingSchool ds on sd.driving_school_id = ds.id inner join DSAdminAccount")
    List<StudentGroup> findByDrivingSchool(@Param("credentialId") Long credentialId);
}
