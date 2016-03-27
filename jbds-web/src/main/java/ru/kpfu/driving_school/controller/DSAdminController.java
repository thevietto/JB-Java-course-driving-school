package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.StudentChangeForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.service.StudentService;
import ru.kpfu.driving_school.util.StudentAccountIsBelongsTeacher;


/**
 * Created by aleksandrpliskin on 16.03.16.
 */
@Controller
@RequestMapping("/admin")
public class DSAdminController {

    @Autowired
    DSAdminService dsAdminService;

    @Autowired
    StudentService studentService;

    StudentAccountIsBelongsTeacher belongsTeacher = new StudentAccountIsBelongsTeacher();

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

    @RequestMapping(value = "/student/{id}/change", method = RequestMethod.GET)
    public String getChangeStudentPage(@PathVariable Long id, Model model) {
        StudentAccount student = studentService.findOneById(id);
        if (belongsTeacher.isBelong(student, dsAdminService.getStudentGroups())) {
            model.addAttribute("student", student);
            return "ds-admin-change";
        }
        return "ds-admin-index";
    }

    @RequestMapping(value = "/student/save", method = RequestMethod.POST)
    public String saveStudentChange(@ModelAttribute StudentChangeForm changeForm, Model model) {
        StudentAccount oldStudent = studentService.findOneById(changeForm.getId());
        if (belongsTeacher.isBelong(oldStudent, dsAdminService.getStudentGroups())) {
            oldStudent.setFio(changeForm.getFio());
            oldStudent.getCredentials().setLogin(changeForm.getLogin());
            if (changeForm.getPassword().length() != 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                oldStudent.getCredentials().setPassword(encoder.encode(changeForm.getPassword()));
            }
            studentService.saveStundet(oldStudent);
        }
        return "ds-admin-index";
    }
    @RequestMapping(value = "/student/{id}/delete", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Long id){
        StudentAccount student = studentService.findOneById(id);
        if (belongsTeacher.isBelong(student, dsAdminService.getStudentGroups())){
            studentService.deleteStudent(student);
        }
        return "ds-admin-index";
    }
}

