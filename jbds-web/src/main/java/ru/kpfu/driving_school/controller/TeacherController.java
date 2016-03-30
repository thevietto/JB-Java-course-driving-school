package ru.kpfu.driving_school.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.driving_school.service.TeacherService;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "")
    public String getTeacherIndex() {
        return "teacher";
    }

    @RequestMapping(value = "/student_groups", method = RequestMethod.GET)
    public String getStudentGroups(Model model) {
        model.addAttribute("groups", teacherService.getStudentGroups());
        return "teacher_student_groups";
    }

    @RequestMapping(value = "/student_groups/${id}", method = RequestMethod.GET)
    public String getStudentGroup(@PathVariable("id") Long id,
                                  Model model) {
        model.addAttribute("group", teacherService.getStudentGroup(id));
        return "teacher_student_group";
    }
}
