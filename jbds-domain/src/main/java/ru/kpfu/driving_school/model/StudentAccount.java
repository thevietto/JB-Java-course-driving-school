package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
@SequenceGenerator(sequenceName = "credential_id_seq", name = "credentials_gen")
public class StudentAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "credentials_gen")
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credentials credentials;

    @Column
    private String fio;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    public StudentAccount() {
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }
}
