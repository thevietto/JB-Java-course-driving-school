package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Answer;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Answer, Long> {
}
