package com.dkk.ssm.dao;

import com.dkk.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-10 20:48
 * @description:
 **/
@Repository("sysLogDao")
public interface SysLogDao {

    @Select("select * from sysLog")
    List<SysLog> findAll() throws Exception;

    @Insert("insert into sysLog (method,visitTime,username,executionTime,ip,url) " +
            "values(#{method},#{visitTime},#{username},#{executionTime},#{ip},#{url})")
    void save(SysLog sysLog) throws Exception;
}
