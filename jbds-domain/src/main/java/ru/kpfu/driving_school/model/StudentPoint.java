package ru.kpfu.driving_school.model;

import ru.kpfu.driving_school.model.enums.Marks;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "student_points_id_seq", name = "student_points_gen", allocationSize = 1)
@Table(name = "student_points")
public class StudentPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_points_gen")
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "mark")
    private Marks marks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

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
}
