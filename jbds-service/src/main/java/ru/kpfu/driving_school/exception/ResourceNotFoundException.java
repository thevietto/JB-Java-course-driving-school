package ru.kpfu.driving_school.exception;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("resource wasn't found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
