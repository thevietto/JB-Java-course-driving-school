package ru.kpfu.driving_school.service.util.impl;

//import com.google.api.services.translate.Translate;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.service.form.StudentForm;
import ru.kpfu.driving_school.service.util.StudentAccountGenerator;

//import com.gtranslate.Translator;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentsFormToStudentsTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private static StudentAccountGenerator generator;

    public static StudentAccount transform(StudentForm form) {
        return generator.generateStudent(form);
    }


}
