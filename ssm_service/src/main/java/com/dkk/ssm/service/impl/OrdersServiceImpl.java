package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.OrdersDao;
import com.dkk.ssm.domain.Orders;
import com.dkk.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 22:04
 * @description:
 **/
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    @Qualifier("ordersDao")
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size) throws Exception {
        //配置分页查询参数
        // 参数page 是页码值  参数Size 代表是每页显示条数
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) throws Exception {
        return ordersDao.findById(id);
    }


}
