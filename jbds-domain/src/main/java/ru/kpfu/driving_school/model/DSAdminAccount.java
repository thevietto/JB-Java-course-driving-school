package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "ds_admin")
@SequenceGenerator(sequenceName = "ds_admin_id_seq", name = "ds_admin_gen")
public class DSAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ds_admin_gen")
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credentials credentials;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    public DSAdminAccount() {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
    }
}
