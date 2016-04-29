package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.driving_school.form.StudentQuestionDialogAnswerForm;
import ru.kpfu.driving_school.form.StudentQuestionForm;
import ru.kpfu.driving_school.model.*;
import ru.kpfu.driving_school.service.*;

import java.util.HashMap;
import java.util.List;

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

    @Autowired
    TaskService taskService;

    @Autowired
    AnswerVariantService answerVariantService;

    @Autowired
    StudentQuestionAnswersService studentQuestionAnswersService;

    @Autowired
    QuestionService questionService;


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
        studentQuestionDialogAnswerService.createNewAnswer(id, form);
        return "redirect:/student/questions/" + id + "/answers";
    }

    private void includeUrl(Model model, String url) {
        model.addAttribute("url", url);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public String getQuestions(@PathVariable ("id") Long id, Model model){
        Task task = taskService.findOne(id);
        List<Question> questions = questionService.getQuestionsByTaskId(id);
        HashMap<String, List<AnswerVariant>> answerVariants = answerVariantService.getAnswerVariantsByQuestions(questions);
        model.addAttribute("questions", questions);
        model.addAttribute("task", task);
        model.addAttribute("answerVariants", answerVariants);
        return "test-executing";
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void setStudentQuestionAnswers(@PathVariable("id") Long taskId, @RequestParam("result") String studentAnswers){
        studentQuestionAnswersService.saveStudentResults(taskId, studentAnswers);
    }
}
