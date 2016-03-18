package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.driving_school.service.form.StudentForm;
import ru.kpfu.driving_school.service.DSAdminService;

import javax.validation.Valid;


/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Controller
public class DSAdminController {

    @Autowired
    DSAdminService dsAdminService;

    @RequestMapping("/admin")
    public String getIndex() {
        return "ds-admin-index";
    }

    @RequestMapping(value = "/admin/add_students", method = RequestMethod.GET)
    public String getPageForAdding() {
        return "ds-admin-adding";
    }

    @RequestMapping(value = "/admin/add_students", method = RequestMethod.POST)
    public String getPageForAdding(@ModelAttribute("studentform") @Valid StudentForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "ds-admin-adding";
        } else {
            dsAdminService.saveNewStudent(form);
            return "ds-admin-index";
        }
    }
}
