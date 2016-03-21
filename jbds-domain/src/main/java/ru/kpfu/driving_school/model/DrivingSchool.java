package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 21.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "driving_school_id_seq", name = "driving_school_gen")
public class DrivingSchool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "driving_school_gen")
    private Long id;

    private String name;

    private String tel;

    private String email;

    public DrivingSchool() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
