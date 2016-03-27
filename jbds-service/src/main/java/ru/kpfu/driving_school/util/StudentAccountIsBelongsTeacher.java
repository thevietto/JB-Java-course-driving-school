package ru.kpfu.driving_school.util;

import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.model.StudentGroup;

import java.util.List;

/**
 * Created by mikl on 27.03.2016.
 */
public class StudentAccountIsBelongsTeacher {
    public boolean isBelong(StudentAccount student,List<StudentGroup> groups) {

        for (StudentGroup group : groups) {
            for (StudentAccount account : group.getStudentAccountList()) {
                if (account.getId() == student.getId()) {
                    return true;
                }
            }
        }
        return false;
    }


}
