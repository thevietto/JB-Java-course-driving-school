package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "questions_id_seq", name = "questions_gen", allocationSize = 1)
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "questions_gen")
    private Long id;

    private String text;

    private String image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinTable(name = "test_questions",
            inverseJoinColumns = @JoinColumn(name = "test_id"),
            joinColumns = @JoinColumn(name = "question_id")
    )
    private Test test;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "questions_answer_variants",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "answer_variant_id")
    )
    private List<AnswerVariant> answerVariants;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "right_answer_id")
    RightAnswer rightAnswer;

    public RightAnswer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(RightAnswer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<AnswerVariant> getAnswerVariants() {
        return answerVariants;
    }

    public void setAnswerVariants(List<AnswerVariant> answerVariants) {
        this.answerVariants = answerVariants;
    }
}
