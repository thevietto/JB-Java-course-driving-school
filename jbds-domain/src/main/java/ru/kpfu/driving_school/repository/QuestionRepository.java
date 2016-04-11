package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Question;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Question findQuestionById(Long questionId);
}
