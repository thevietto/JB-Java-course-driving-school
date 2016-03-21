package ru.kpfu.driving_school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.service.DSAdminService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by azat on 21.03.16.
 */
@Controller
@RequestMapping("/admin")
public class FileController {

    @Autowired
    DSAdminService adminService;


    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String getUploadPage(){
        return "excel-load";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            adminService.createGroupWithExcel(file);
            return ("File "+file.getOriginalFilename()+" has been successfully uploaded");
        }catch (Exception e){
            return e.getMessage();
        }
    }

}