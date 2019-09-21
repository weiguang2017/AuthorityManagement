package com.dkk.ssm.service;

import com.dkk.ssm.domain.Orders;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 22:02
 * @description:
 **/
public interface OrdersService {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(String id) throws Exception;
}
