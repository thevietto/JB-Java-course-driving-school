package ru.kpfu.driving_school.service.impl;

import org.springframework.stereotype.Service;
import ru.kpfu.driving_school.service.PlainService;

/**
 * Created by aleksandrpliskin on 15.03.16.
 */
@Service
public class PlainServiceImpl implements PlainService {
    @Override
    public String getHello() {
        return "Hello";
    }
}
