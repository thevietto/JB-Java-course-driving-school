package ru.kpfu.driving_school.model;

import javax.persistence.*;

@Entity
@Table(name = "ds_admin")
public class DSAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "credential_id")
    private Credentials credentials;

    private Boolean subscription;

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

    public Boolean getSubscription() {
        return subscription;
    }

    public void setSubscription(Boolean subscription) {
        this.subscription = subscription;
    }
}
