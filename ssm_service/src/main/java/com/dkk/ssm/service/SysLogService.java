package com.dkk.ssm.service;

import com.dkk.ssm.domain.SysLog;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-10 20:42
 * @description:
 **/
public interface SysLogService {

    List<SysLog> findAll() throws Exception;

    void save(SysLog sysLog) throws Exception;

}
