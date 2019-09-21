package com.dkk.ssm.controller;

import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 22:29
 * @description:
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    @Qualifier("permissionService")
    private PermissionService permissionService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv= new ModelAndView();
        List<Permission> permissions=permissionService.findAll();
        mv.addObject("permissionList", permissions);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Permission permission) throws Exception {
        permissionService.save(permission);
        return "redirect:findAll.do";
    }


}
