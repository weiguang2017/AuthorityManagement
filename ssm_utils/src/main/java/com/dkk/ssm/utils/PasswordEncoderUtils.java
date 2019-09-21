package com.dkk.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-09 20:37
 * @description:
 **/
public class PasswordEncoderUtils {

    public static String passwordEncode(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
       return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        System.out.println(passwordEncode("123"));
    }
}
