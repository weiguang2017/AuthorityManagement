package com.dkk.ssm.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ldk
 * @program: ssm_dk
 * @create: 2019-08-05 19:49
 * @description:
 **/

public class StringToDateConverter implements Converter<String,Date> {

    private String datePattern;

    public StringToDateConverter(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public Date convert(String source) {
        SimpleDateFormat sdf=new SimpleDateFormat(datePattern);
        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("invalid date format. " +
                    "Please use this pattern\"" + datePattern + "\"");
        }
    }
}
