package com.dkk.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 11:42
 * @description:
 **/
public class DateUtils {

    //日期状换为字符串
    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format=sdf.format(date);
        return format;
    }

    //字符串转换为日期
    public static Date string2Date(String format,String patt) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        Date parse=sdf.parse(format);
        return parse;
    }
}
