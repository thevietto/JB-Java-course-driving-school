package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@Table(name = "student_questions_answers")
@SequenceGenerator(sequenceName = "student_questions_answers_id_seq", name = "student_questions_answers_gen")
public class StudentQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_questions_answers_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentAccount studentAccount;

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

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(StudentAccount studentAccount) {
        this.studentAccount = studentAccount;
    }
}
