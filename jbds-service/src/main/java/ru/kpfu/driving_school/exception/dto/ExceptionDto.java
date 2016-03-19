package ru.kpfu.driving_school.exception.dto;

/**
 * Created by etovladislav on 19.03.16.
 */
public class ExceptionDto {

    private Integer errorCode;

    private String description;

    public ExceptionDto() {
    }

    public ExceptionDto(Integer errorCode, String description) {
        this.errorCode = errorCode;
        this.description = description;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
