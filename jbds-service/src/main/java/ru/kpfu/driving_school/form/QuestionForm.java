package ru.kpfu.driving_school.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Created by etovladislav on 01.04.16.
 */
public class QuestionForm {

    @NotNull
    private Long categoryId;

    @NotEmpty
    private String text;

    private MultipartFile multipartFile;

    @Size(min = 4)
    private String[] answerVariantForm;

    @NotNull
    private Integer rightAnswer;

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

    public Integer getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(Integer rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
