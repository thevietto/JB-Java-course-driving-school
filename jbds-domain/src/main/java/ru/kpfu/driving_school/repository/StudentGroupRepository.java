package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by aleksandrpliskin on 24.03.16.
 */
@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
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
    List<StudentGroup> findByDrivingSchool(@Param("credentialId") Long credentialId);


    @Query(value = "select sGroup from StudentGroup sGroup join sGroup.drivingSchool dSchool where dSchool = (select admin.drivingSchool from DSAdminAccount admin where admin.credentials = :credentials)")
    List<StudentGroup> getByDrivingSchool(@Param("credentials") Credentials credentials);
}
