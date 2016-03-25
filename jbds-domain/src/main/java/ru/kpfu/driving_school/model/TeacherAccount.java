package ru.kpfu.driving_school.model;

import javax.persistence.*;


@Entity
@Table(name = "teacher")
@SequenceGenerator(sequenceName = "teacher_id_seq", name = "teacher_gen", allocationSize = 1)
public class TeacherAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_gen")
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credentials credentials;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    private String fio;

    public TeacherAccount() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }
}

