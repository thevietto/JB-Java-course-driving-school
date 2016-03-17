package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Controller
@RequestMapping(value = "ds-admin")
public class DSAdminController {


    @RequestMapping(value = {"/", "/index"})
    public String getIndex() {
        return "ds-admin-index";
    }
}
