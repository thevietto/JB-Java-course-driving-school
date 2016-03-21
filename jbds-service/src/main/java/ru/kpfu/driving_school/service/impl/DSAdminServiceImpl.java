package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialsRepository;
import ru.kpfu.driving_school.repository.DSAdminRepository;
import ru.kpfu.driving_school.repository.StudentRepository;
import ru.kpfu.driving_school.service.DSAdminService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.function.Function;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
@Service
public class DSAdminServiceImpl implements DSAdminService {

    @Autowired
    private DSAdminRepository dsAdminRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private Function<StudentForm, StudentAccount> generator;

    @Autowired
    private Function<DSAccountForm, DSAdminAccount> transformer;

    @Autowired
    private Function<File, List<StudentForm>> excelParser;

    @Override
    public void addStudents(List<StudentAccount> students) {
        studentRepository.save(students);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public void deleteStudent(String fio) {
        studentRepository.delete(studentRepository.findOneByFio(fio));
    }

    @Override
    public void deleteStudent(StudentAccount student) {
        studentRepository.delete(student);
    }

    @Override
    public void saveNewStudent(StudentForm form) {
        StudentAccount student = generator.apply(form);
        studentRepository.save(student);
    }

    @Override
    public void createDSAccount(DSAccountForm dsAccountForm) {
        DSAdminAccount dsAdmin = transformer.apply(dsAccountForm);
        dsAdminRepository.save(dsAdmin);
    }

    @Override
    public void createGroupWithExcel(MultipartFile file){
        String name = null;

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();

                name = file.getOriginalFilename();

                File uploadedFile = new File(name);

                String dir = uploadedFile.getAbsolutePath();

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

                List<StudentForm> list = excelParser.apply(uploadedFile);

                list.forEach(this::saveNewStudent);


                if (uploadedFile.exists()){
                    uploadedFile.delete();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
