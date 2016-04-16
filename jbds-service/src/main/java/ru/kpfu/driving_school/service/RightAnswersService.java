package ru.kpfu.driving_school.service;

import ru.kpfu.driving_school.model.RightAnswer;

import java.util.List;

/**
 * Created by Azat Zaripov on 11.04.16.
 */
public interface RightAnswersService {

    List<RightAnswer> findAll();

}
