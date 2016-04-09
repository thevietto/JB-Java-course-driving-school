package ru.kpfu.driving_school.exception;

/**
 * Created by aleksandrpliskin on 31.03.16.
 */
public class NoMarksForSuchStudentException extends ResourceNotFoundException {

    public NoMarksForSuchStudentException() {
        super("that student doesn't have got any marks");
    }
}
