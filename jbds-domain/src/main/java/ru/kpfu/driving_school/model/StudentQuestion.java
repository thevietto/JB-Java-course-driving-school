package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Entity
@Table(name = "student_questions_dialog")
@SequenceGenerator(sequenceName = "student_questions_dialog_id_seq", name = "student_questions_dialog_gen", allocationSize = 1)
public class StudentQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_questions_dialog_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentQuestion{" +
                "id=" + id +
                ", student=" + student +
                ", question='" + question + '\'' +
                '}';
    }
}
