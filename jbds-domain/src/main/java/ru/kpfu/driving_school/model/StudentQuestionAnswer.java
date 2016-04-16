package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@Table(name = "student_question_answers")
@SequenceGenerator(sequenceName = "student_question_answers_id_seq", name = "student_question_answers_gen")
public class StudentQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_question_answers_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToOne
    @JoinColumn(name = "answer_variant_id")
    private AnswerVariant answerVariant;

    public AnswerVariant getAnswerVariant() {
        return answerVariant;
    }

    public void setAnswerVariant(AnswerVariant answerVariant) {
        this.answerVariant = answerVariant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
