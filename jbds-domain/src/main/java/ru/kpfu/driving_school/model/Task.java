package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 29.03.16.
 */
@Entity
@SequenceGenerator(sequenceName = "task_id_seq", name = "task_seq", allocationSize = 1)
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "driving_school_id")
    private DrivingSchool drivingSchool;

    public DrivingSchool getDrivingSchool() {
        return drivingSchool;
    }

    public void setDrivingSchool(DrivingSchool drivingSchool) {
        this.drivingSchool = drivingSchool;
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
}
