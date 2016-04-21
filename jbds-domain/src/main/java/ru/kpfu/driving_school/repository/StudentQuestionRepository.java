package ru.kpfu.driving_school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.StudentQuestion;

import java.util.List;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Repository
public interface StudentQuestionRepository extends JpaRepository<StudentQuestion, Long> {

    @Query("select sq from StudentQuestion sq where sq.student in " +
            "(select s from Student s where s.studentGroup in " +
            "(select stud.studentGroup from Student stud where stud.credential = :credentials))"
    )
    List<StudentQuestion> findByStudentGroupOfCurrentStudent(@Param("credentials") Credential credentials);

    @Query("select sq from StudentQuestion sq where sq.student in " +
            "(select s from Student s where s.studentGroup.id " +
//            " in " +
//            "(select sg from StudentGroup sg where sg.id" +
            " = :id)")
    List<StudentQuestion> findByStudentGroupId(@Param("id") Long id);
}
