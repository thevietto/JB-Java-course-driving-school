package ru.kpfu.driving_school.service.util;

//import com.google.api.services.translate.Translate;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.driving_school.model.StudentAccount;
import ru.kpfu.driving_school.service.form.StudentForm;

//import com.gtranslate.Translator;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentsFormToStudentsTransformer {

    static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    StudentAccountGenerator generator;

    public static StudentAccount transform(StudentForm form) {

    }

    public String translate(String fname) {
        Translate translator = new Translate();
        System.out.println("data received from jsf form =" + fname);
        String russian = null;
        try {
            russian = translator.translate(fname, Language.ENGLISH, Language.RUSSIAN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(" translated text of the form  " + russian);
        String staticText = "This is static text inside the function";
        String russian2 = null;
        try {
            russian2 = translator.translate(staticText, Language.ENGLISH, Language.RUSSIAN);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Translated static text = " + russian2);
        return russian;
    }

}
