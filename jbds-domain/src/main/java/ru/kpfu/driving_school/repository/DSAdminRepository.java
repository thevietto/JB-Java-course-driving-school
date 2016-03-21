package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Repository
public interface DSAdminRepository extends JpaRepository<DSAdminAccount, Long> {

    @Query(value = "select * from ds_admin WHERE credential_id = (?1)", nativeQuery = true)
    DSAdminAccount findOneByCredentialId(Long credentialId);

}
