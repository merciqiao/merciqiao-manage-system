package com.carloan.common.utils;


import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by MMM on 2017/08/22.
 * 时间操作工具
 */
@Component
public class DateUtil {
    /**
     * 获取当前unix时间戳,毫秒数
     * @return
     */
    public static long GetUnixTimestampMillis(){
        return System.currentTimeMillis();
    }
    /**
     * 获取当前unix时间戳,秒数
     * @return
     */
    public static long GetUnixTimestamp(){
        return System.currentTimeMillis()/1000;
    }
    /**
     * 获取当前unix时间戳,秒数
     * @return
     */
    public static String GetUnixTimestampMillisString(){
        return String.valueOf(GetUnixTimestampMillis());
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String GetDateNow(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    /**
     * 计算得到MongoDB存储的日期，（默认情况下mongo中存储的是标准的时间，中国时间是东八区，存在mongo中少8小时，所以增加8小时）
     * http://www.iteye.com/problems/88507
     *
     * @author: Gao Peng
     * @date: 2016年5月4日 上午9:26:23
     * @param: @param
     *             date
     * @param: @return
     * @return: Date
     */
    public static Date getMongoDate() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar ca = Calendar.getInstance();
//        ca.setTime(new Date());
//        ca.add(Calendar.HOUR_OF_DAY, 8);
//        return ca.getTime();
        return  new Date();
    }
    /**
     * 字符串转换成日期
     * @param str
     * @return date
     */
    public static Date StrToDate(String str) {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String dateToStr(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
    /**
     * 获取天数偏差的日期
     * @param diffDay
     * @return
     */
    public static String GetDiffDate(Integer diffDay){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, diffDay);
        date = calendar.getTime();
        String strDate= sdf.format(date);
        return strDate;
    }
    /**
     * 判断字符串是否合法日期型
     * @param str
     * @return
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess=true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess=false;
        }
        return convertSuccess;
    }
    /**
     * 获得当天的起始时间
     * @return
     */
    public static String getDiffStartDate(Integer diffDay){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, diffDay);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        String strDate= sdf.format(calendar.getTime());
        return strDate;
    }
    /**
     * 获取当天截止时间
     * @return
     */
    public static String getDiffEndDate(Integer diffDay){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, diffDay);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 59);
        String strDate= sdf.format(calendar.getTime());
        return strDate;
    }
    /**
     * 获取天数偏差的日期
     * @param diffDay
     * @return
     */
    public static String GetDiffDateDay(Integer diffDay){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, diffDay);
        date = calendar.getTime();
        String strDate= sdf.format(date);
        return strDate;
    }
}
