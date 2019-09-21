package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 09:39
 * @description:
 **/
@Repository("productDao")
public interface ProductDao {

    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;



    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Insert("insert into product (productNum, productName,cityName,departureTime,productPrice," +
            "productDesc,productStatus) " +
            "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice}," +
            "#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;
}
