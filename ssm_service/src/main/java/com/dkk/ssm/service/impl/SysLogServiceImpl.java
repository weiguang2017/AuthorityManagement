package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.SysLogDao;
import com.dkk.ssm.domain.SysLog;
import com.dkk.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-10 20:45
 * @description:
 **/
@Service("sysLogService")
@Transactional
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    @Qualifier("sysLogDao")
    private SysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }
}
