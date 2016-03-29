package ru.kpfu.driving_school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.kpfu.driving_school.exception.LoginAlreadyExistsException;
import ru.kpfu.driving_school.form.DSAccountForm;
import ru.kpfu.driving_school.model.Credential;
import ru.kpfu.driving_school.model.DSAdmin;
import ru.kpfu.driving_school.model.enums.UserRole;
import ru.kpfu.driving_school.repository.CredentialRepository;

import java.util.function.Function;

/**
 * Created by etovladislav on 19.03.16.
 */
@Component
public class DSAdminAccountTransformer implements Function<DSAccountForm, DSAdmin> {

    @Autowired
    CredentialRepository credentialRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public DSAdmin apply(DSAccountForm dsAccountForm) {
        if (credentialRepository.findOneByLogin(dsAccountForm.getLogin()) != null) {
            throw new LoginAlreadyExistsException();
        }
        Credential credentials = new Credential();
        credentials.setLogin(dsAccountForm.getLogin());
        credentials.setPassword(encoder.encode(dsAccountForm.getPassword()));
        credentials.setRole(UserRole.ROLE_ADMIN);
        credentialRepository.save(credentials);
        DSAdmin dsAdmin = new DSAdmin();
        dsAdmin.setCredentials(credentials);
        return dsAdmin;
    }
}
