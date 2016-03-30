package ru.kpfu.driving_school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.exception.NoGroupForTeacherException;
import ru.kpfu.driving_school.exception.NoSuchStudentException;
import ru.kpfu.driving_school.exception.NoSuchStudentGroupException;
import ru.kpfu.driving_school.exception.dto.ExceptionDto;

/**
 * Created by etovladislav on 19.03.16.
 */
@ControllerAdvice
public class ExceptionHandlingController {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(LoginAlreadyExistsException.class)
    @ResponseBody
    public ExceptionDto loginAlreadyExists() {
        return new ExceptionDto(400, "Login already exists");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ExceptionDto missingParamterHandler(Exception exception) {
        return new ExceptionDto(400, "Required parameter missing");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchStudentGroupException.class)
    @ResponseBody
    public ExceptionDto noSuchStudentGroup() {
        return new ExceptionDto(400, "нет такой студенческой группы");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoGroupForTeacherException.class)
    @ResponseBody
    public ExceptionDto noStudentGroupsForTeacher() {
        return new ExceptionDto(400, "у учителя нет групп");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchStudentException.class)
    @ResponseBody
    public ExceptionDto noSuchStudent() {
        return new ExceptionDto(400, "такого студента не существует");
    }
}
