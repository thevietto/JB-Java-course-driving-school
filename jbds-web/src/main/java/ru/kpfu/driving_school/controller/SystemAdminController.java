package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Controller
@RequestMapping("/system")
public class SystemAdminController {

    @RequestMapping(value = {""})
    public String getSystemIndex() {
        return "system-admin";
    }

    @RequestMapping(value = {"/change/student/"})
    public String getSystemChangeStudent() {

        return "system-admin-change-student";
    }


}
