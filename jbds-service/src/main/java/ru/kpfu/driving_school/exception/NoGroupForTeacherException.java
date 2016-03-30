package ru.kpfu.driving_school.exception;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public class NoGroupForTeacherException extends ResourceNotFoundException {

    public NoGroupForTeacherException() {
        super("no groups for that teacher");
    }
}
