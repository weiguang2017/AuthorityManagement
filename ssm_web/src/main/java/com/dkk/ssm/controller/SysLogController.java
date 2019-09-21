package com.dkk.ssm.controller;

import com.dkk.ssm.domain.SysLog;
import com.dkk.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-10 20:33
 * @description:
 **/
@Controller("sysLogController")
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<SysLog> sysLogs= sysLogService.findAll();
        mv.addObject("sysLogs", sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }

}
