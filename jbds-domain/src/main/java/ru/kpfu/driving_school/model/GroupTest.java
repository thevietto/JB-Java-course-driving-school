package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 02.04.16.
 */
@Entity
@Table(name = "group_tests")
@SequenceGenerator(sequenceName = "group_tests_id_seq", name = "group_tests_gen", allocationSize = 1)
public class GroupTest {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_tests_gen")
    private Long id;

    @OneToOne
    @JoinColumn(name = "test_id")
    private Test test;

    @OneToOne
    @JoinColumn(name = "student_group_id")
    private StudentGroup studentGroup;

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentGroup getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }
}
