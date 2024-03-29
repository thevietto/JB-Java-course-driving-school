package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.AnswerVariant;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Repository
public interface AnswerVariantRepository extends JpaRepository<AnswerVariant, Long> {
}
