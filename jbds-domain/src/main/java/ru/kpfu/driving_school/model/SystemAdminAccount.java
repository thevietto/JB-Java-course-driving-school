package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "system_admin")
public class SystemAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
