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

    @RequestMapping(value = "/create-account-ds", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createAccountDS(@ModelAttribute DSAccountForm dsAccountForm) {
        dsAdminService.createDSAccount(dsAccountForm);
    }

    @RequestMapping(value = "/removeSubscription", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeSubscription(@RequestParam Long id) {
        System.out.println(id);
    }

    @RequestMapping(value = "/addSubscription", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addSubscription(@RequestParam Long id) {
        System.out.println(id);
    }


}
