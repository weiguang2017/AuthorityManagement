package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Member;
import com.dkk.ssm.domain.Orders;
import com.dkk.ssm.domain.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 20:53
 * @description:
 **/
@Repository("ordersDao")
public interface OrdersDao {
    @Select("select * from orders")
    @Results(id = "ordersMap_all",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.dkk.ssm.dao.ProductDao.findById")),
    })
    List<Orders> findAll() throws Exception;



    @Select("select * from orders where id=#{id}")
    @Results(id = "ordersMap_ById",value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",
                    javaType = Product.class,
                    one = @One(select = "com.dkk.ssm.dao.ProductDao.findById")),
            @Result(property = "member",column = "memberId",
                    javaType = Member.class,
                    one = @One(select = "com.dkk.ssm.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",
                    javaType = java.util.List.class,
                    many = @Many(select = "com.dkk.ssm.dao.TravellerDao.findByOrdersId")),
    })
    Orders findById(String id) throws Exception;
}
