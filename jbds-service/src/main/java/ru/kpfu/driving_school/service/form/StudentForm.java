package ru.kpfu.driving_school.service.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */
public class StudentForm {

    @Size(min = 5, max = 100, message = "введите в виде: Иванов Иван Иванович")
    @Pattern(regexp = ".+ .+ .+")
    private List<String> fio;

    public List<String> getFio() {
        return fio;
    }

    public void setFio(List<String> fio) {
        this.fio = fio;
    }
}
