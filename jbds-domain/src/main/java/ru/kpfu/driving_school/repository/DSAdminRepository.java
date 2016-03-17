package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.DSAdminAccount;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Repository
public interface DSAdminRepository extends JpaRepository<DSAdminAccount, Long> {
}
