package ru.kpfu.driving_school.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Entity
public class SystemAdminAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Credentials credentials;

    private List<DSAdminAccount> DSadmins;

    public SystemAdminAccount() {
    }
}
