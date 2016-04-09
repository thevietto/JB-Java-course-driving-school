package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 24.03.16.
 */
@Entity
@Table(name = "student_groups")
@SequenceGenerator(sequenceName = "student_groups_id_seq", name = "student_groups_gen", allocationSize = 1)
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_groups_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroup", fetch = FetchType.LAZY)
    private List<Student> students;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
