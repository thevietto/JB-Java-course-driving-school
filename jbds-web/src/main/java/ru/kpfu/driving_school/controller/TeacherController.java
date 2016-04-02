package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.kpfu.driving_school.form.QuestionForm;
import ru.kpfu.driving_school.repository.CategoryRepository;
import ru.kpfu.driving_school.service.QuestionService;
import ru.kpfu.driving_school.service.StudentService;
import ru.kpfu.driving_school.service.TeacherService;
import ru.kpfu.driving_school.service.TestService;
import ru.kpfu.driving_school.util.SecurityUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

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

    @Autowired
    QuestionService questionService;

    @Autowired
    CategoryRepository categoryRepository;

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

    @RequestMapping(value = "/test/create", method = RequestMethod.GET)
    public String getCreateTestPage(Model model) {
        return "create_test";
    }

    @RequestMapping(value = "/test/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.SEE_OTHER)
    public String saveTest(@RequestParam("description") String description) {
        Long testId = testService.save(description);
        return "redirect:/teacher/test/" + testId + "/questions";
    }

    @RequestMapping(value = "/test/{id}/questions", method = RequestMethod.GET)
    public String getQuestionsPage(@PathVariable Long id, Model model) {
        model.addAttribute("questions", questionService.getQuestions(id));
        model.addAttribute("testId", id);
        return "questions";
    }

    @RequestMapping(value = "/test/{id}/questions/create", method = RequestMethod.GET)
    public String createQuestionPage(@PathVariable Long id, Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("testId", id);
        return "create_question";
    }

    @RequestMapping(value = "/test/{id}/questions/create", method = RequestMethod.POST)
    public String saveQuestion(@PathVariable Long id, @ModelAttribute QuestionForm form) {
        return "redirect:/teacher/test/" + id + "/questions";
    }

    @RequestMapping(value = "/test/upload", method = RequestMethod.GET)
    public String getUploadPage() {
        return "upload";
    }

    //Метод сделан для теста загрузки, есть моменты которые надо поправить
    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    @ResponseStatus(HttpStatus.OK)
    public void handleFileUpload(@RequestParam("name") String name,
                                   @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                //Берет твой путь и создает папку tmpFiles, тож пока для теста
                File dir = new File(System.getProperty("user.home") + File.separator + "tmpFiles");
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                String newFileName = UUID.randomUUID().toString() + "." //название картинки пока так
                        + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + newFileName);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
            } catch (IOException e) {
                //тут тож пока ничего нет
            }
        }
    }

}