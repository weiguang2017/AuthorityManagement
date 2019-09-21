package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.RoleDao;
import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.domain.Role;
import com.dkk.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 22:04
 * @description:
 **/
@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    @Qualifier("roleDao")
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }



    @Override
    public Role findById(String roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionsToRole(String roleId, String[] permissionIds) throws Exception {
        for (String permissionId : permissionIds) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }


    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }
}
