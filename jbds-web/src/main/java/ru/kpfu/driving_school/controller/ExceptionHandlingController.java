package ru.kpfu.driving_school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.exception.ResourceNotFoundException;
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

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ExceptionDto resourceNorExists(Exception e) {
        System.out.println(e.getMessage());
        return new ExceptionDto(404, e.getMessage());
    }

}
