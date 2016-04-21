package ru.kpfu.driving_school.form;

import javax.validation.constraints.NotNull;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
public class StudentQuestionAnswerForm {

    @NotNull
    private String answer;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
