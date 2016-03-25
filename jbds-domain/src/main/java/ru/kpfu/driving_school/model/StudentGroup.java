package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 24.03.16.
 */
@Entity
@Table(name = "student_group")
@SequenceGenerator(sequenceName = "student_group_id_seq", name = "student_group_gen", allocationSize = 1)
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_group_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentGroup")
    private List<StudentAccount> studentAccountList;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherAccount teacherAccount;

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

    public List<StudentAccount> getStudentAccountList() {
        return studentAccountList;
    }

    public void setStudentAccountList(List<StudentAccount> studentAccountList) {
        this.studentAccountList = studentAccountList;
    }

    public TeacherAccount getTeacherAccount() {
        return teacherAccount;
    }

    public void setTeacherAccount(TeacherAccount teacherAccount) {
        this.teacherAccount = teacherAccount;
    }
}
