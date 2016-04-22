package ru.kpfu.driving_school.model;

import javax.persistence.*;

/**
 * Created by aleksandrpliskin on 21.04.16.
 */
@Table(name = "student_question_dialog_answers")
@Entity
@SequenceGenerator(sequenceName = "student_question_dialog_answers_id_seq", name = "student_question_dialog_answers_gen", allocationSize = 1)
public class StudentQuestionDialogAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_question_dialog_answers_gen")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_question_id")
    private StudentQuestion studentQuestion;

    private String answer;

    @ManyToOne
    @JoinColumn(name = "answerer_credential_id")
    private Credential credential;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentQuestion getStudentQuestion() {
        return studentQuestion;
    }

    public void setStudentQuestion(StudentQuestion studentQuestion) {
        this.studentQuestion = studentQuestion;
    }

    @Override
    public String toString() {
        return "StudentQuestionAnswer{" +
                "answer='" + answer + '\'' +
                ", id=" + id +
                ", studentQuestion=" + studentQuestion +
                ", credential=" + credential +
                '}';
    }
}
