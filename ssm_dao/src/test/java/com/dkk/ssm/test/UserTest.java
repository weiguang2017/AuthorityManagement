package com.dkk.ssm.test;

import com.dkk.ssm.dao.UserDao;
import com.dkk.ssm.domain.UserInfo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-08 23:02
 * @description:
 **/
public class UserTest {
    /*public static void main(String[] args) throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDao userDao=(UserDao)ac.getBean("userDao");
        System.out.println(userDao);
        UserInfo user=userDao.findByUsername("ldk");
        System.out.println(user.getPassword());
    }
*/

}
