package ru.kpfu.driving_school.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentForm {

    @Size(min = 1, max = 30, message = "имя неправильно введено")
    @Pattern(regexp = "[А-Я].+")
    private String firstname;

    @Size(min = 1, max = 30, message = "фамилия неправильно введено")
    @Pattern(regexp = "[А-Я].+")
    private String surname;

    @Size(min = 1, max = 30, message = "отчество неправильно введено")
    @Pattern(regexp = "[А-Я].+")
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
