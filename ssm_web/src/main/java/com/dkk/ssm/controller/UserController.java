package com.dkk.ssm.controller;

import com.dkk.ssm.domain.Role;
import com.dkk.ssm.domain.UserInfo;
import com.dkk.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-07 15:18
 * @description:
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user", userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo=userService.findById(userId);
        List<Role> otherRoles=userService.findOtherRoles(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRolesToUser.do")
    public String addRolesToUser(String userId, @RequestParam(name = "ids",required = true)
            String[] roleIds) throws Exception {
        userService.addRolesToUser(userId, roleIds);
        return "redirect:findAll.do";
    }


    //@PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<UserInfo> users=userService.findAll();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    //@PreAuthorize("authentication.principal.username=='lbr'")
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll.do";
    }

}
