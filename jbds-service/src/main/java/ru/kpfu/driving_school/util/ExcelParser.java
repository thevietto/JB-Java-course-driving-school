package ru.kpfu.driving_school.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.StudentAccount;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Created by Azat Zaripov on 21.03.16.
 */

@Component
public class ExcelParser implements Function<File, List<StudentForm>>{

    @Override
    public List<StudentForm> apply(File file) {
        HSSFWorkbook workbook = null;
        List<StudentForm> students = new ArrayList<>();
        try {
            workbook = new HSSFWorkbook(new FileInputStream(file.getAbsolutePath()));
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow(i);

                StudentForm studentForm = new StudentForm();

                studentForm.setLastname(row.getCell(2).getStringCellValue());
                studentForm.setFirstname(row.getCell(1).getStringCellValue());
                studentForm.setSurname(row.getCell(0).getStringCellValue());

                students.add(studentForm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }
}
