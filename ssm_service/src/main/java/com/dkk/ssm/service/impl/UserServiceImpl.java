package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.UserDao;
import com.dkk.ssm.domain.Role;
import com.dkk.ssm.domain.UserInfo;
import com.dkk.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-07 15:27
 * @description:
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

    @Autowired
    @Qualifier("passwordEncoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(UserInfo userInfo) throws Exception {
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    @Override
    public void addRolesToUser(String userId, String[] roleIds) throws Exception {
        for (String roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public List<Role> findOtherRoles(String userId) throws Exception {
        return userDao.findOtherRoles(userId);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }


    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        User user = new User(userInfo.getUsername(), userInfo.getPassword(),
                userInfo.getStatus() == 0 ? false : true, true, true,
                true, getAuthority(userInfo.getRoles()));
        return user;
    }

    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }
}
