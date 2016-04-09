package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "students")
@SequenceGenerator(sequenceName = "students_id_seq", name = "students_gen", allocationSize = 1)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "students_gen")
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;

    @Column
    private String fio;

    @ManyToOne
    @JoinColumn(name = "student_group_id", nullable = false)
    private StudentGroup studentGroup;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Credential getCredentials() {
        return credential;
    }

    public void setCredentials(Credential credential) {
        this.credential = credential;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }
}
