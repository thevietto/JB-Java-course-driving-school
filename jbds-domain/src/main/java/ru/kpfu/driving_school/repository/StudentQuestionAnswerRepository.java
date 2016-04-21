package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.StudentQuestionAnswer;

import java.util.List;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Repository
public interface StudentQuestionAnswerRepository extends JpaRepository<StudentQuestionAnswer, Long> {

    @Query(value = "select q from StudentQuestionAnswer q where q.studentQuestion = (select sc from StudentQuestion sc where sc.id = :questionId)")
    List<StudentQuestionAnswer> findByStudentQuestionId(@Param("questionId") Long questionId);

}
