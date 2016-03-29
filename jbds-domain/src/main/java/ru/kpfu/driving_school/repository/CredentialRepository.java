package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;

/**
 * Created by etovladislav on 17.03.16.
 */
@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

    Credential findOneByLogin(String login);

}
