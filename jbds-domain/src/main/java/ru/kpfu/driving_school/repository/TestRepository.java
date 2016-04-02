package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Test;

import java.util.List;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

    @Query(value = "select t from Test t join t.drivingSchool ds where ds.id = (select sGroup.id from StudentGroup sGroup where sGroup.id = :groupId)")
    List<Test> findByGroupId(@Param("groupId") Long groupId);

    Test findOneByDescription(String description);
}
