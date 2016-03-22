package ru.kpfu.driving_school.util.impl;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.util.SecurityUtils;

/**
 * Created by aleksandrpliskin on 22.03.16.
 */
@Component
public class SecurityUtilsImpl implements SecurityUtils {

    public Credentials getCurrentUser() {
        return ((Credentials) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
