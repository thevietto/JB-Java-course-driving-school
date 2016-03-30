package ru.kpfu.driving_school.model;

import ru.kpfu.driving_school.model.enums.Marks;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "student_marks_id_seq", name = "student_marks_gen", allocationSize = 1)
@Table(name = "student_marks")
public class StudentMark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_marks_gen")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "mark")
    private Marks marks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "created_at")
    private Date createdAt;

    public StudentMark() {
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

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
