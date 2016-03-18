package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 15.03.16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "index"})
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/forbidden")
    public String getForbidden() {
        return "forbidden";
    }

}
