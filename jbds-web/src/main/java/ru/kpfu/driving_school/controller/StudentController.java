package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.driving_school.service.StudentService;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping("")
    public String getStudentPage() {
        return "student";
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String getTasks(Model model) {
        model.addAttribute("tasks",studentService.getTasks());
        return "student_tasks";
    }

}
