package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.driving_school.model.Credentials;

/**
 * Created by etovladislav on 17.03.16.
 */
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Credentials findOneByLogin(String login);
}
