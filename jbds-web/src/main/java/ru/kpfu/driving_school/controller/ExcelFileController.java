package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.service.DSAdminService;

/**
 * Created by Azat Zaripov on 22.03.16.
 */
@Controller
@RequestMapping("/admin/add_students")
public class ExcelFileController {

    @Autowired
    DSAdminService adminService;

    @RequestMapping(value = "/upload_file", method = RequestMethod.GET)
    public String getExcelUploadPage() {
        return "excel-load";
    }

    @RequestMapping(value = "/students_file", method = RequestMethod.POST)
    @ResponseBody
    public String uploadExcelFile(@RequestParam("file") MultipartFile file) {
        try {
            adminService.loadStudentGroupFromExcel(file);
            return ("File " + file.getOriginalFilename() + " has been successfully uploaded");
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
