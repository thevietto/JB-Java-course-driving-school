package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 24.03.16.
 */
@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    @Query(
            value = "SELECT\n" +
                    "  student_groups.id,\n" +
                    "  student_groups.driving_school_id,\n" +
                    "  student_groups.teacher_id\n" +
                    "FROM student_groups\n" +
                    "  JOIN driving_schools ON student_groups.driving_school_id = driving_schools.id\n" +
                    "  JOIN ds_admins ON ds_admins.driving_school_id = driving_schools.id\n" +
                    "WHERE ds_admins.credential_id = :credentialId",
            nativeQuery = true)
    List<StudentGroup> findByDrivingSchool(@Param("credentialId") Long credentialId);


    @Query(value = "select sGroup from StudentGroup sGroup join sGroup.drivingSchool dSchool where dSchool = (select admin.drivingSchool from DSAdmin admin where admin.credential = :credential)")
    List<StudentGroup> getByDrivingSchool(@Param("credential") Credential credential);
}
