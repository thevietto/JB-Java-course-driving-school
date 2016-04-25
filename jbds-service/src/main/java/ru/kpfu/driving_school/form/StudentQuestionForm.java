package ru.kpfu.driving_school.form;

import javax.validation.constraints.NotNull;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
public class StudentQuestionForm {

    @NotNull
    private String question;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
