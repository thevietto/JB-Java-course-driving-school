package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "student_task_id_seq", name = "student_task_seq", allocationSize = 1)
@Table(name = "student_task")
public class StudentTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_task_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentAccount studentAccount;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    private Date deadline;

    @Column(name = "is_done")
    private Boolean isDone;

    private Long point;

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(StudentAccount studentAccount) {
        this.studentAccount = studentAccount;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
