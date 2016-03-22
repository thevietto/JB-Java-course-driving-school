package ru.kpfu.driving_school.form;

/**
 * Created by etovladislav on 19.03.16.
 */
public class DSAccountForm {

    private String login;

    private String password;

    private Long drivingSchoolId;

    public DSAccountForm() {
    }

    public Long getDrivingSchoolId() {
        return drivingSchoolId;
    }

    public void setDrivingSchoolId(Long drivingSchoolId) {
        this.drivingSchoolId = drivingSchoolId;
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
