package ru.kpfu.driving_school.exception;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public class NoSuchStudentException extends ResourceNotFoundException {

    public NoSuchStudentException() {
        super("no such student");
    }
}
