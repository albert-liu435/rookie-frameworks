package com.rookie.bigdata.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Classname DateUtils
 * @Description TODO
 * @Author rookie
 * @Date 2022/11/10 15:22
 * @Version 1.0
 */
public class DateUtils {

    public static Date getDate(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static void main(String[] args) {
//        Date date = getDate(new Date(), -10);
//        System.out.println(date);


        double pow = Math.pow(2, 48);
        System.out.println(pow);
    }





}
