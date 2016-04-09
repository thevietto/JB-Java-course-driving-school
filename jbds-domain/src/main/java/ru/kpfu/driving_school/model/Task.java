package ru.kpfu.driving_school.model;

import ru.kpfu.driving_school.model.enums.TaskStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by aleksandrpliskin on 02.04.16.
 */
@Entity
@Table(name = "tasks")
@SequenceGenerator(sequenceName = "tasks_id_seq", name = "tasks_gen", allocationSize = 1)
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_gen")
    private Long id;

    @ManyToOne
    @JoinTable(name = "tasks_tests",
                joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "test_id")
    )
    private Test test;

    @ManyToOne
    @JoinTable(
            name = "tasks_students",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Student student;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    private Date deadline;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

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
