package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.driving_school.service.DSAdminService;

/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Controller
@RequestMapping(value = "ds-admin")
public class DSAdminController {

    @Autowired
    DSAdminService adminService;

    @RequestMapping(value = {"/", "/index"})
    public String getIndex() {
        return "ds-admin-index";
    }
}
