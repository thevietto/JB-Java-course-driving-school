package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @RequestMapping("")
    public String getStudentPage() {
        return "student";
    }
}
