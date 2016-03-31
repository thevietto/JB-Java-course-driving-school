package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by etovladislav on 31.03.16.
 */
@Controller
public class TeacherController {
    @RequestMapping(value = "/test/new", method = RequestMethod.GET)
    public String createTest() {
        return "create-test";
    }
}
