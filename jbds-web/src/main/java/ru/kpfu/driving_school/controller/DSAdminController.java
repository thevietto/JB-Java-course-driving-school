package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.service.DSAdminService;


/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Controller
@RequestMapping("/admin")
public class DSAdminController {

    @Autowired
    DSAdminService dsAdminService;

    @RequestMapping(value = "")
    public String getIndex() {
        return "ds-admin-index";
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.GET)
    public String getNewStudentPage() {
        return "ds-admin-adding";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String getNewStudentPage(@RequestParam String firstname, @RequestParam String surname, @RequestParam String lastname) {
        StudentForm form = new StudentForm();
        form.setFirstname(firstname);
        form.setSurname(surname);
        form.setLastname(lastname);
        dsAdminService.saveNewStudent(form);
        return "ds-admin-index";
    }

    @RequestMapping(value = "/student_groups", method = RequestMethod.GET)
    public String getStudentGroups(Model model) {
        model.addAttribute("groups", dsAdminService.getStudentGroups());
        return "student-groups";
    }

    @RequestMapping(value = "/student_groups/new", method = RequestMethod.GET)
    public String getPageForCreatingStudentsGroup() {
        return "create-students-group";
    }

    @RequestMapping(value = "/student_groups", method = RequestMethod.POST)
    public String addStudentsGroup(@RequestParam("teacher") String teacherName,
                                   @RequestParam("file") MultipartFile file) {
        try {
            dsAdminService.createStudentGroup(teacherName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ds-admin-index";
    }

}

