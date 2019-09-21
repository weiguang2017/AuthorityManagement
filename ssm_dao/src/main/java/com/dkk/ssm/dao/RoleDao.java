package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-08 21:17
 * @description:
 **/
@Repository("roleDao")
public interface RoleDao {

    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select="com.dkk.ssm.dao.PermissionDao.findPermissionsByRoleId"))
    })
    List<Role> findRolesByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;



    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id =true, property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
                    many = @Many(select="com.dkk.ssm.dao.PermissionDao.findPermissionsByRoleId"))
    })
    Role findById(String roleId) throws Exception;


    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId) throws Exception;


    @Insert("insert into role_permission (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId) throws Exception;


    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;







}
