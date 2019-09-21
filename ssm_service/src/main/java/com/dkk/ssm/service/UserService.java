package com.dkk.ssm.service;

import com.dkk.ssm.domain.Role;
import com.dkk.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-07 15:20
 * @description:
 **/
public interface UserService extends UserDetailsService{

    List<UserInfo> findAll() throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userId) throws Exception;

    void addRolesToUser(String userId,String[] roleIds) throws Exception;

    void save(UserInfo userInfo) throws Exception;

}
