package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.PermissionDao;
import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 22:34
 * @description:
 **/
@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    @Qualifier("permissionDao")
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
