package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 20:50
 * @description:
 **/
@Repository("permissionDao")
public interface PermissionDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionsByRoleId(String id);


    @Select("select * from permission")
    List<Permission> findAll() throws Exception;


    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

}
