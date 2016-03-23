package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;

import javax.transaction.Transactional;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Repository
public interface DSAdminRepository extends JpaRepository<DSAdminAccount, Long> {

    DSAdminAccount findOneByCredentials(Credentials credentials);

    @Modifying
    @Query(value = "UPDATE DSAdminAccount ds SET ds.isActive = :isActive WHERE ds.id = :id")
    void setActive(@Param("id") Long id, @Param("isActive") Boolean isActive);

}
