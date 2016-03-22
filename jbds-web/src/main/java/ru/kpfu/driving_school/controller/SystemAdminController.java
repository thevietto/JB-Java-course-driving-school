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

    @RequestMapping(value = "/accounts/driving_school", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createAccountDS(@ModelAttribute DSAccountForm dsAccountForm) {
        dsAdminService.createDSAccount(dsAccountForm);
    }

    @RequestMapping(value = "/driving_school/{id}/subscription", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void removeSubscription(@PathVariable Long id) {
        systemAdminService.removeSubscription(id);
    }

    @RequestMapping(value = "/driving_school/{id}/subscription", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void addSubscription(@PathVariable Long id) {
        systemAdminService.addSubscription(id);
    }


}
