package ru.kpfu.driving_school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
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
}
