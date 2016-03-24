package ru.kpfu.driving_school.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.StudentForm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azat Zaripov on 22.03.16.
 */
@Component
public class ExcelStudentParser {

    public List<StudentForm> parse(MultipartFile file) throws IOException {
        List<StudentForm> students = new ArrayList<>();
        if (file.getOriginalFilename().endsWith(".xls")) {
            HSSFWorkbook workbook = new HSSFWorkbook(file.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);

                StudentForm studentForm = new StudentForm();

                studentForm.setLastname(row.getCell(2).getStringCellValue());
                studentForm.setFirstname(row.getCell(1).getStringCellValue());
                studentForm.setSurname(row.getCell(0).getStringCellValue());
                students.add(studentForm);
            }
        } else if (file.getOriginalFilename().endsWith(".xlsx")){
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                XSSFRow row = sheet.getRow(i);

                StudentForm studentForm = new StudentForm();

                studentForm.setLastname(row.getCell(2).getStringCellValue());
                studentForm.setFirstname(row.getCell(1).getStringCellValue());
                studentForm.setSurname(row.getCell(0).getStringCellValue());
                students.add(studentForm);
            }
        }

        return students;
    }
}
