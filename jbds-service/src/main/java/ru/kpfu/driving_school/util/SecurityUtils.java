package ru.kpfu.driving_school.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.kpfu.driving_school.model.Credential;

/**
 * Created by aleksandrpliskin on 22.03.16.
 */
public class SecurityUtils {

    public static Credential getCurrentUser() {
        return ((Credential) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

}
