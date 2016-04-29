package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;

/**
 * Created by Azat Zaripov on 25.04.16.
 */
public interface StudentQuestionAnswerRepository extends JpaRepository<StudentQuestionAnswer, Long> {
}
