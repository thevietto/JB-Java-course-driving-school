package ru.kpfu.driving_school.form;

import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.model.AnswerVariant;

import java.util.List;

/**
 * Created by etovladislav on 01.04.16.
 */
public class QuestionForm {

    private Long categoryId;

    private String text;

    private MultipartFile multipartFile;

    private String[] answerVariantForm;

    private Integer isRight;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String[] getAnswerVariantForm() {
        return answerVariantForm;
    }

    public void setAnswerVariantForm(String[] answerVariantForm) {
        this.answerVariantForm = answerVariantForm;
    }

    public Integer getIsRight() {
        return isRight;
    }

    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }
}
