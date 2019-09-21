package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Role;
import com.dkk.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-07 15:21
 * @description:
 **/
@Repository("userDao")
public interface UserDao {

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Select("select * from users where username=#{userName}")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select="com.dkk.ssm.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findByUsername(String userName) throws Exception;

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select="com.dkk.ssm.dao.RoleDao.findRolesByUserId"))
    })
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(String userId) throws Exception;

    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId) throws Exception;


    @Insert("insert into users (username,email,password,phoneNum,status) " +
            "values(#{username},#{email},#{password},#{phoneNum},#{status})")
    void save(UserInfo user) throws Exception;







}
