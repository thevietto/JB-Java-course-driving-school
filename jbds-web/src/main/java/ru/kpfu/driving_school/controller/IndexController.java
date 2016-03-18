package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.driving_school.service.PlainService;

/**
 * Created by aleksandrpliskin on 15.03.16.
 */
@Controller
public class IndexController {

    @Autowired(required = true)
    PlainService plainService;

    @RequestMapping(value = {"/", "index"})
    public String getIndex() {
//        System.out.println(plainService.getHello());
        return "index";
    }

    @RequestMapping("/forbidden")
    public String getForbidden() {
        return "forbidden";
    }

}
