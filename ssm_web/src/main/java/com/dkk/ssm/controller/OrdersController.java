package com.dkk.ssm.controller;

import com.dkk.ssm.domain.Orders;
import com.dkk.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 20:47
 * @description:
 **/
@Controller("ordersController")
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    @Qualifier("ordersService")
    private OrdersService ordersService;

    //@Secured("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, size);
        //PageInfo就是一个分页Bean
        PageInfo pageInfo=new PageInfo(ordersList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true) String id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders=ordersService.findById(id);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
