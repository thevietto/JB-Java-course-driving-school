package ru.kpfu.driving_school.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

        Workbook workbook;

        if (file.getOriginalFilename().endsWith(".xls")) {
            workbook = new HSSFWorkbook(file.getInputStream());
        } else if (file.getOriginalFilename().endsWith(".xlsx")) {
            workbook = new XSSFWorkbook(file.getInputStream());
        } else {
            throw new IOException("Wrong file extension");
        }

        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            StudentForm studentForm = new StudentForm();

            studentForm.setLastname(row.getCell(2).getStringCellValue());
            studentForm.setFirstname(row.getCell(1).getStringCellValue());
            studentForm.setSurname(row.getCell(0).getStringCellValue());
            students.add(studentForm);
        }
            return students;
    }
}
