package com.dkk.ssm.service;

import com.dkk.ssm.domain.Product;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 09:42
 * @description:
 **/
public interface ProductService {
    /**
     * @description:查询所有产品
     */
    List<Product> findAll() throws Exception;

    /**
     * @description:保存产品
     */
    void save(Product product) throws Exception;
}
