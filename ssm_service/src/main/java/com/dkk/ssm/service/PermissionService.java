package com.dkk.ssm.service;

import com.dkk.ssm.domain.Permission;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 22:33
 * @description:
 **/
public interface PermissionService {

    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;
}
