package ru.kpfu.driving_school.model;

import ru.kpfu.driving_school.model.enums.UserRole;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Entity
@Table(name = "credential")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    public Credentials() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
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

    public void setPassword(String password) {
        this.password = password;
    }
}
