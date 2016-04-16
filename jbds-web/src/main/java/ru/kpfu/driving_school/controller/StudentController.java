package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.driving_school.model.*;
import ru.kpfu.driving_school.service.*;
import ru.kpfu.driving_school.util.SecurityUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    TaskService taskService;

    @Autowired
    AnswerVariantService answerVariantService;

    @Autowired
    StudentQuestionAnswersService studentQuestionAnswersService;

    @Autowired
    QuestionsService questionsService;

    @Autowired
    RightAnswersService rightAnswersService;

    @RequestMapping("")
    public String getStudentPage() {
        return "student";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String getTasks(Model model) {
        model.addAttribute("tasks",studentService.getStudentTasks());
        return "student_tasks";
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public String getQuestions(@PathVariable ("id") Long id, Model model){
        Task task = taskService.findOne(id);
        List<Question> questions = questionsService.getQuestionsByTaskId(id);
        HashMap<String, List<AnswerVariant>> answerVariants = answerVariantService.getAnswerVariantsByQuestions(questions);
        model.addAttribute("questions", questions);
        model.addAttribute("task", task);
        model.addAttribute("answers", answerVariants);
        return "test-executing";
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.POST)
    public String setStudentQuestionAnswers(@PathVariable("id")Long id, HttpServletRequest request, Model model){
        Enumeration<String> enumeration = request.getParameterNames();
        Student student = studentService.findByCredential(SecurityUtils.getCurrentUser());
        Test test = taskService.findOne(id).getTest();
        List<AnswerVariant> answerVariants = new ArrayList<>();

        while(enumeration.hasMoreElements()){
            Long studentAnswerId = Long.parseLong(request.getParameter(enumeration.nextElement()));
            AnswerVariant answerVariant = answerVariantService.findOne(studentAnswerId);
            answerVariants.add(answerVariant);
        }

        List<StudentQuestionAnswer> studentQuestionAnswers = studentQuestionAnswersService.saveStudentResults(student, test, answerVariants);
        model.addAttribute("studentanswers", studentQuestionAnswers);
        return "test-result";
    }

}
