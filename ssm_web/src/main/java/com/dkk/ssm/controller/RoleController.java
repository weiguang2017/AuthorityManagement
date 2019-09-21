package com.dkk.ssm.controller;

import com.dkk.ssm.domain.Permission;
import com.dkk.ssm.domain.Role;
import com.dkk.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 21:57
 * @description:
 **/
@Controller("roleController")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    @Qualifier("roleService")
    private RoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv= new ModelAndView();
        List<Role> roles=roleService.findAll();
        mv.addObject("roleList", roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/findRoleByIdAndAllPermissions.do")
    public ModelAndView findRoleByIdAndAllPermissions(@RequestParam(name = "id",required = true) String roleId) throws Exception {
        ModelAndView mv=new ModelAndView();
        Role role=roleService.findById(roleId);
        List<Permission> otherPermissions=roleService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }

    @RequestMapping("/addPermissionsToRole.do")
    public String addRolesToUser(@RequestParam(name = "roleId",required = true) String roleId,
                                 @RequestParam(name = "ids",required = true) String[] permissionIds) throws Exception {
        roleService.addPermissionsToRole(roleId, permissionIds);
        return "redirect:findAll.do";
    }


    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

}
