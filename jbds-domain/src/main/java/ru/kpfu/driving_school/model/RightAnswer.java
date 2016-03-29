package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "right_answers_id_seq", name = "right_answers_gen", allocationSize = 1)
@Table(name = "right_answers")
public class RightAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "right_answers_gen")
    private Long id;

    @OneToOne
    @JoinColumn(name = "answer_variant_id")
    private AnswerVariant answerVariant;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

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

    public AnswerVariant getAnswerVariant() {
        return answerVariant;
    }

    public void setAnswerVariant(AnswerVariant answerVariant) {
        this.answerVariant = answerVariant;
    }
}
