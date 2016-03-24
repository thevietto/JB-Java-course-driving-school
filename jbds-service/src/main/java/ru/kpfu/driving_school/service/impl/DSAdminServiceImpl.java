package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.form.StudentForm;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.DrivingSchool;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.model.StudentGroup;
import ru.kpfu.driving_school.repository.*;
import ru.kpfu.driving_school.service.DSAdminService;
import ru.kpfu.driving_school.util.ExcelStudentParser;
import ru.kpfu.driving_school.util.SecurityUtils;

import java.io.IOException;
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
    private DrivingSchoolRepository drivingSchoolRepository;

    @Autowired
    private StudentGroupRepository studentGroupRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private Function<StudentForm, StudentAccount> generator;

    @Autowired
    private Function<DSAccountForm, DSAdminAccount> transformer;

    @Autowired
    private ExcelStudentParser excelStudentParser;

    @Autowired
    private Function<List<StudentForm>, List<StudentAccount>> studentsTransformer;

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
        DrivingSchool drivingSchool = dsAdminRepository.findOneByCredentials(SecurityUtils.getCurrentUser()).getDrivingSchool();
        student.setDrivingSchool(drivingSchool);
        studentRepository.save(student);
    }

    @Override
    public void createDSAccount(DSAccountForm dsAccountForm) {
        DSAdminAccount dsAdmin = transformer.apply(dsAccountForm);
        DrivingSchool drivingSchool = drivingSchoolRepository.findOne(dsAccountForm.getDrivingSchoolId());
        dsAdmin.setDrivingSchool(drivingSchool);
        dsAdminRepository.save(dsAdmin);
    }

    @Override
    public List<StudentGroup> getStudentGroups() {
        DrivingSchool drivingSchool = dsAdminRepository.findOneByCredentials(SecurityUtils.getCurrentUser()).getDrivingSchool();
        return studentGroupRepository.findByDrivingSchool(drivingSchool);
    }

    @Override
    public void createStudentGroup(String teacherName, MultipartFile file) {
        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setTeacherAccount(teacherRepository.findOneByFio(teacherName));
        try {
            List<StudentAccount> studentAccounts = studentsTransformer.apply(excelStudentParser.parse(file));
            studentAccounts.forEach(this::saveNewStudent);//TODO
            studentGroup.setStudentAccountList(
                    studentsTransformer.apply(excelStudentParser.parse(file))
            );
            studentGroupRepository.save(studentGroup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadStudentGroupFromExcel(MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                List<StudentForm> list = excelStudentParser.parse(file);
                list.forEach(this::saveNewStudent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
