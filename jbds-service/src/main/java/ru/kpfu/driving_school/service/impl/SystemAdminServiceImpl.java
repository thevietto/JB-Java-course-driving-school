package ru.kpfu.driving_school.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.driving_school.model.DSAdminAccount;
import ru.kpfu.driving_school.repository.DSAdminRepository;
import ru.kpfu.driving_school.service.SystemAdminService;

/**
 * Created by etovladislav on 21.03.16.
 */
@Service
public class SystemAdminServiceImpl implements SystemAdminService {

    @Autowired
    DSAdminRepository dsAdminRepository;

    @Override
    @Transactional
    public void addSubscription(Long id) {
        DSAdminAccount dsAdminAccount = dsAdminRepository.findOne(id);
        dsAdminAccount.setActive(Boolean.TRUE);
        dsAdminRepository.save(dsAdminAccount);
    }

    @Override
    public void removeSubscription(Long id) {
        DSAdminAccount dsAdminAccount = dsAdminRepository.findOne(id);
        dsAdminAccount.setActive(Boolean.FALSE);
        dsAdminRepository.save(dsAdminAccount);
    }
}
