package com.dkk.ssm.controller;

import com.dkk.ssm.domain.Product;
import com.dkk.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 10:25
 * @description:
 **/
@Controller("productController")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    //@RolesAllowed("ROLE_ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> ps=productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

}
