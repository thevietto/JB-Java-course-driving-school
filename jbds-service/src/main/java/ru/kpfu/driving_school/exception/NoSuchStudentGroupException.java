package ru.kpfu.driving_school.exception;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public class NoSuchStudentGroupException extends ResourceNotFoundException {

    public NoSuchStudentGroupException() {
        super("no such student group");
    }
}
