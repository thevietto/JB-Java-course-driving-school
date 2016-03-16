package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Entity
public class DSAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Credentials credentials;

    public DSAdminAccount() {
    }
}
