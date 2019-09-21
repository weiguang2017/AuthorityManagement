package com.dkk.ssm.service.impl;

import com.dkk.ssm.dao.ProductDao;
import com.dkk.ssm.domain.Product;
import com.dkk.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 09:44
 * @description:
 **/
@Service("productService")
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("productDao")
    private ProductDao productDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception{
        productDao.save(product);
    }
}
