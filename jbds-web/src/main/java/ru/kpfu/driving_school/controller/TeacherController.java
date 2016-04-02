package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kpfu.driving_school.service.StudentService;
import ru.kpfu.driving_school.service.TeacherService;
import ru.kpfu.driving_school.service.TestService;

/**
 * Created by aleksandrpliskin on 30.03.16.
 */
@Controller
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Autowired
    TestService testService;

    @RequestMapping(value = "")
    public String getTeacherIndex() {
        return "teacher";
    }

    @RequestMapping(value = "/student_groups",
            method = RequestMethod.GET)
    public String getStudentGroups(Model model) {
        model.addAttribute("groups", teacherService.getStudentGroups());
        return "teacher_student_groups";
    }

    @RequestMapping(value = "/student_groups/{id}",
            method = RequestMethod.GET)
    public String getStudentGroup(Model model,
                                  @PathVariable("id") Long id) {
        model.addAttribute("group", teacherService.getStudentGroup(id));
        return "teacher_student_group";
    }

    @RequestMapping(value = "/student_groups/{id}/task/new",
            method = RequestMethod.GET)
    public String getFormToAddTaskForStudentGroup(Model model,
                                                  @PathVariable("id") Long id) {
        model.addAttribute("group", teacherService.getStudentGroup(id));
        model.addAttribute("tests", testService.getTests(id));
        return "teacher_student_group_add_task";
    }

    @RequestMapping(value = "/student_groups/{id}/task",
            method = RequestMethod.POST)
    public String addTaskForStudentGroup(Model model,
                                         @PathVariable("id") Long id,
                                         @RequestParam("test_name") String name,
                                         @RequestParam("description") String description
    ) {
        testService.createGroupTest(id, name, description);
        return "redirect:/teacher/student_groups/" + id;
    }


    @RequestMapping(value = "/student_groups/{id}/students",
            method = RequestMethod.GET)
    public String getStudents(Model model,
                              @PathVariable("id") Long id) {
        model.addAttribute("students", teacherService.getStudentsOfStudentGroup(id));
        return "teacher_student_group_id_students";
    }

    @RequestMapping(value = "/student_groups/{id}/students/{studentId}",
            method = RequestMethod.GET)
    public String getStudent(Model model,
                             @PathVariable("id") Long id,
                             @PathVariable("studentId") Long studentId) {
        model.addAttribute("student", studentService.getStudent(studentId, id));
        return "teacher_student";
    }

    @RequestMapping(value = "/student_groups/{id}/students/{studentId}/student_points",
            method = RequestMethod.GET)
    public String getStudentPoints(Model model,
                                   @PathVariable("id") Long id,
                                   @PathVariable("studentId") Long studentId) {
        model.addAttribute("marks", studentService.getStudentMarks(studentId, id));
        model.addAttribute("student", studentService.getStudent(studentId, id));
        return "teacher_student_marks";
    }

    @RequestMapping(value = "/student_groups/{id}/students/{studentId}/student_points",
            method = RequestMethod.POST)
    public String setStudentPoints(@PathVariable("id") Long id,
                                   @PathVariable("studentId") Long studentId,
                                   @RequestParam("description") String description,
                                   @RequestParam("student_point") String studentPoint) {
        studentService.setStudentMarks(studentId, description, studentPoint, id);
        return "redirect:/teacher/student_groups/" + id + "/students/" + studentId + "/student_points";
    }

    @RequestMapping(value = "/test/new", method = RequestMethod.GET)
    public String createTest() {
        return "create-test";
    }

}
