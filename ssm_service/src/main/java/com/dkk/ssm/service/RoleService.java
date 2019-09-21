package com.dkk.ssm.service;

import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.domain.Role;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 22:03
 * @description:
 **/
public interface RoleService {

    List<Role> findAll() throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOtherPermissions(String roleId) throws Exception;

    void addPermissionsToRole(String roleId,String[] permissionIds) throws Exception;

    void save(Role role) throws Exception;
}
