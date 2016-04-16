package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@Table(name = "tests")
@SequenceGenerator(sequenceName = "tests_id_seq", name = "tests_gen", allocationSize = 1)
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tests_gen")
    private Long id;

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "test_questions",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<Question> questions;

    @ManyToOne
    @JoinTable(name = "ds_tests",
            joinColumns = @JoinColumn(name = "test_id"),
            inverseJoinColumns = @JoinColumn(name = "ds_id")
    )
    private DrivingSchool drivingSchool;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
