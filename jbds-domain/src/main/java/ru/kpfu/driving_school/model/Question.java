package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "question_id_seq", name = "question_seq", allocationSize = 1)
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_seq")
    private Long id;

    private String name;

    private String image;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private Long point;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
