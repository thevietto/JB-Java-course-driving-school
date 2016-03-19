package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.model.Credentials;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialsRepository;

import java.util.function.Function;

/**
 * Created by etovladislav on 19.03.16.
 */
@Component
public class DSAdminAccountTransformer implements Function<DSAccountForm, DSAdminAccount> {

    @Autowired
    CredentialsRepository credentialsRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public DSAdminAccount apply(DSAccountForm dsAccountForm) {
        if (credentialsRepository.findOneByLogin(dsAccountForm.getLogin()) != null) {
            throw new LoginAlreadyExistsException();
        }
        Credentials credentials = new Credentials();
        credentials.setLogin(dsAccountForm.getLogin());
        credentials.setPassword(encoder.encode(dsAccountForm.getPassword()));
        credentials.setRole(UserRole.ROLE_ADMIN);
        credentialsRepository.save(credentials);
        DSAdminAccount dsAdminAccount = new DSAdminAccount();
        dsAdminAccount.setCredentials(credentials);
        return dsAdminAccount;
    }
}
