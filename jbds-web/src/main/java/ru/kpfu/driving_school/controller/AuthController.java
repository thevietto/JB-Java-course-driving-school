package ru.kpfu.driving_school.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by aleksandrpliskin on 17.03.16.
 */
@Controller
public class AuthController {

    @RequestMapping(value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) Boolean error,
                               Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", error);
        }
        return "login";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/ds-admin/";
        } else if (request.isUserInRole("ROLE_STUDENT")) {
            return "redirect:/student/";
        } else if (request.isUserInRole("ROLE_SYSTEM_ADMIN")) {
            return "redirect:/system/";
        } else {
            return "login";
        }
    }
}
