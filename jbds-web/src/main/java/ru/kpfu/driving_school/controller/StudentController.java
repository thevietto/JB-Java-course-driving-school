package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.driving_school.form.StudentQuestionDialogAnswerForm;
import ru.kpfu.driving_school.form.StudentQuestionForm;
import ru.kpfu.driving_school.service.StudentQuestionDialogAnswerService;
import ru.kpfu.driving_school.service.StudentQuestionService;
import ru.kpfu.driving_school.service.StudentService;

import javax.validation.Valid;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentQuestionService studentQuestionService;

    @Autowired
    StudentQuestionDialogAnswerService studentQuestionDialogAnswerService;

    @RequestMapping("")
    public String getStudentPage() {
        return "student";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String getTasks(Model model) {
        model.addAttribute("tasks", studentService.getStudentTasks());
        return "student_tasks";
    }

    @RequestMapping(value = "/questions/new", method = RequestMethod.GET)
    public String getFormToAskQuestion(Model model) {
        model.addAttribute("questionForm", new StudentQuestionForm());
        includeUrl(model, "/student/questions");
        return "ask_question";
    }

    @RequestMapping(value = "/questions", method = RequestMethod.POST)
    public String createNewQuestion(@ModelAttribute("questionForm") @Valid StudentQuestionForm form) {
        studentQuestionService.createStudentQuestion(form);
        return "redirect:/student/questions";
    }

    @RequestMapping(value = "/questions", method = RequestMethod.GET)
    public String getGroupQuestions(Model model) {
        model.addAttribute("questions", studentQuestionService.getGroupQuestions());
        includeUrl(model, "/student/questions");
        return "student_questions";
    }

    @RequestMapping(value = "/questions/{id}/answers", method = RequestMethod.GET)
    public String getStudentQuestionDiscussion(@PathVariable("id") Long id, Model model) {
        model.addAttribute("question", studentQuestionService.getQuestionById(id));
        model.addAttribute("answers", studentQuestionDialogAnswerService.getAnswersByQuestion(id));
        model.addAttribute("answerForm", new StudentQuestionDialogAnswerForm());
        includeUrl(model, "/student/questions");
        return "discussion";
    }

    @RequestMapping(value = "/questions/{id}/answers", method = RequestMethod.POST)
    public String createNewAnswer(@PathVariable("id") Long id,
                                  @ModelAttribute("answerForm") @Valid StudentQuestionDialogAnswerForm form) {
        studentQuestionDialogAnswerService.creteNewAnswer(id, form);
        return "redirect:/student/questions/" + id + "/answers";
    }

    private void includeUrl(Model model, String url) {
        model.addAttribute("url", url);
    }

}
