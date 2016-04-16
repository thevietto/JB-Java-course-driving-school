package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.model.RightAnswer;
import ru.kpfu.driving_school.repository.RightAnswerRepository;
import ru.kpfu.driving_school.service.RightAnswersService;

import java.util.List;

/**
 * Created by Azat Zaripov on 11.04.16.
 */
@Service
public class RightAnswersServiceImpl implements RightAnswersService{

    @Autowired
    RightAnswerRepository rightAnswerRepository;

    @Override
    public List<RightAnswer> findAll() {
        return null;
    }
}
