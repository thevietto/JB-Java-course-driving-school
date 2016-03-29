package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "system_admins")
@SequenceGenerator(sequenceName = "system_admins_id_seq", name = "system_admins_gen", allocationSize = 1)
public class SystemAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_admins_gen")
    private Long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credential credential;


    public SystemAdmin() {
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
}
