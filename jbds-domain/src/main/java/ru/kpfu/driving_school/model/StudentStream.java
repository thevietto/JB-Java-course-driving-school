package ru.kpfu.driving_school.model;

/**
 * Created by mikl on 19.03.2016.
 */

import javax.persistence.*;

@Entity
@Table(name = "student_stream")
public class StudentStream {

    StudentStream() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
