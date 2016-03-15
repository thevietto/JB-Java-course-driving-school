package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.driving_school.model.User;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
