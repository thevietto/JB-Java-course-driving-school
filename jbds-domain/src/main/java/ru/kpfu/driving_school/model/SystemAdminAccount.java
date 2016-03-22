package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "system_admin")
@SequenceGenerator(sequenceName = "system_admin_id_seq", name = "system_admin_gen")
public class SystemAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "system_admin_gen")
    private Long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credentials credentials;


    public SystemAdminAccount() {
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
}
