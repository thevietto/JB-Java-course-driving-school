package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "answer_id_seq", name = "answer_seq", allocationSize = 1)
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "answer_seq")
    private Long id;

    private String name;

    private Boolean right;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getRight() {
        return right;
    }

    public void setRight(Boolean right) {
        this.right = right;
    }
}
