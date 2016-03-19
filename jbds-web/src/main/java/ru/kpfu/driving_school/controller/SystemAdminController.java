package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.service.DSAdminService;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@RestController
@RequestMapping("/system")
public class SystemAdminController {

    @Autowired
    DSAdminService dsAdminService;

    @RequestMapping(value = {""})
    public String getSystemIndex() {
        return "system-admin";
    }

    @RequestMapping(value = "/create-account-ds", method = RequestMethod.POST, consumes = "application/json;utf8")
    @ResponseStatus(HttpStatus.OK)
    public void createAccountDS(@RequestBody DSAccountForm dsAccountForm) {
        dsAdminService.createDSAccount(dsAccountForm);
    }
}
