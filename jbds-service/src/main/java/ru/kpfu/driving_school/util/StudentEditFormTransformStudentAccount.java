package ru.kpfu.driving_school.util;

import ru.kpfu.driving_school.form.StudentEditForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.StudentAccount;

/**
 * Created by mikl on 29.03.2016.
 */
public class StudentEditFormTransformStudentAccount {
    public static StudentAccount transform(StudentEditForm editForm){
        StudentAccount changeStudent = new StudentAccount();
        changeStudent.setId(editForm.getId());
        changeStudent.setFio(editForm.getFio());
        changeStudent.setCredentials(new Credentials());
        changeStudent.getCredentials().setPassword(editForm.getPassword());
        changeStudent.getCredentials().setLogin(editForm.getLogin());
        return changeStudent;
    }
}
