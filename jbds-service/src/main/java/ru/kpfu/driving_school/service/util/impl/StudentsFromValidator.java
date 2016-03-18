package ru.kpfu.driving_school.service.util.impl;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kpfu.driving_school.model.StudentAccount;

import java.util.regex.Pattern;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentsFromValidator implements Validator {

    private Pattern pattern = Pattern.compile(".+ .+ .+");

    @Override
    public boolean supports(Class<?> aClass) {
        return StudentAccount.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        StudentAccount studentAccount = (StudentAccount) o;
        if (studentAccount.getFio() == null || !studentAccount.getFio().matches(String.valueOf(pattern))) {
            errors.reject("fio", "фио введено неверно");
        }
    }
}
