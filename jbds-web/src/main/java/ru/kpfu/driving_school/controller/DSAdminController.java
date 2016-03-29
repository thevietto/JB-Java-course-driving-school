package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.StudentEditForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.repository.DSAdminRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.service.StudentService;
import ru.kpfu.driving_school.util.StudentEditFormTransformStudentAccount;


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

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    DSAdminRepository dsRepository;

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

    @RequestMapping(value = "/ds_admin_accounts/student/{id}", method = RequestMethod.GET)
    public String getChangeStudentPage(@PathVariable Long id, Model model) {
        if (dsAdminService.dsAdminSuccessEditStudent(studentRepository.findOne(id).getId())) {
            StudentAccount student = studentRepository.findOne(id);
            model.addAttribute("student", student);
            return "ds-admin-change";
        }
        return "ds-admin-index";
    }

    @RequestMapping(value = "/ds_admin_accounts/student/{id}", method = RequestMethod.PUT)
    public String saveStudentChange(@PathVariable("id") Long id, @ModelAttribute StudentEditForm changeForm, Model model) {
        changeForm.setId(id);
        if (dsAdminService.dsAdminSuccessEditStudent(id)) {
            dsAdminService.updateStudent(StudentEditFormTransformStudentAccount.transform(changeForm));
        }
        return "ds-admin-index";
    }

    @RequestMapping(value = "/ds_admin_accounts/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Long id) {
        StudentAccount student = studentRepository.findOne(id);
        if (dsAdminService.dsAdminSuccessEditStudent(student.getId())) {
            dsRepository.delete(student.getId());
        }
        return "ds-admin-index";
    }
}

