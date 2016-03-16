package ru.kpfu.driving_school.model;

import ru.kpfu.driving_school.model.enums.UserRole;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Entity
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    public Credentials() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passsword) {
        this.password = passsword;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole userRole) {
        this.role = userRole;
    }
}
