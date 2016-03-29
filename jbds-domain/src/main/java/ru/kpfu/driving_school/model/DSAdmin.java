package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "ds_admins")
@SequenceGenerator(sequenceName = "ds_admins_id_seq", name = "ds_admins_gen", allocationSize = 1)
public class DSAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ds_admins_gen")
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    public DSAdmin() {
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
