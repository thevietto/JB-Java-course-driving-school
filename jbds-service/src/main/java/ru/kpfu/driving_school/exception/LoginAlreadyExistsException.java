package ru.kpfu.driving_school.exception;


/**
 * Created by etovladislav on 19.03.16.
 */
public class LoginAlreadyExistsException extends RuntimeException{

    public LoginAlreadyExistsException() {
        super("Login already exists");
    }
}
