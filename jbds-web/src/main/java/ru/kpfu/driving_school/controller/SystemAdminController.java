package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.service.SystemAdminService;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@RestController
@RequestMapping("/system")
public class SystemAdminController {

    @Autowired
    DSAdminService dsAdminService;

    @Autowired
    SystemAdminService systemAdminService;

    @RequestMapping(value = {""})
    public String getSystemIndex() {
        return "system-admin";
    }

    @RequestMapping(value = "/createAccountDs", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createAccountDS(@ModelAttribute DSAccountForm dsAccountForm) {
        dsAdminService.createDSAccount(dsAccountForm);
    }

    @RequestMapping(value = "/removeSubscription", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void removeSubscription(@RequestParam Long id) {
        systemAdminService.removeSubscription(id);
    }

    @RequestMapping(value = "/addSubscription", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addSubscription(@RequestParam Long id) {
        systemAdminService.addSubscription(id);
    }


}
