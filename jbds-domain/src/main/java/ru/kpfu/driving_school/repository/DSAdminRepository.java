package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.DSAdmin;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Repository
public interface DSAdminRepository extends JpaRepository<DSAdmin, Long> {

    DSAdmin findOneByCredential(Credential credential);

    @Modifying
    @Query(value = "UPDATE DSAdmin ds SET ds.isActive = :isActive WHERE ds.id = :id")
    void setActive(@Param("id") Long id, @Param("isActive") Boolean isActive);

}
