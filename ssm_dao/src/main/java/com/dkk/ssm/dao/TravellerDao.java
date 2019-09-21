package com.dkk.ssm.dao;

import com.dkk.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-06 11:41
 * @description:
 **/
public interface TravellerDao {

    @Select("select * from traveller where id in " +
            "(select travellerid from ORDER_TRAVELLER where orderid=#{ordersId})")
    List<Traveller> findByOrdersId(String ordersId) throws Exception;

}
