package ru.kpfu.driving_school.util;

import ru.kpfu.driving_school.model.Credentials;

/**
 * Created by aleksandrpliskin on 22.03.16.
 */
public interface SecurityUtils {

    Credentials getCurrentUser();

}
