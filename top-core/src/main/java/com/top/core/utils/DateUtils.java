package com.top.core.utils;

import org.joda.time.DateTime;
import org.triiskelion.tinyutils.DateTimeUtils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Wang Lei.
 * Date on 2014/12/24
 * Time 21:24
 * TODO
 */
public class DateUtils {

    public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String DEFAULT_FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public static final String DEFAULT_FORMAT2 = "yyyy-MM-dd HH:mm";
    public static final String dtLong = "yyMMddHHmm";

    public static final String dtLong2 = "yyyyMMddhhmmss";

    public static DateTime fromDate(Date date, int hour, int minute) {

        return new DateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), hour,
                minute);
    }

    /**
     * 获得指定日期的前一天
     *
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBefore(String specifiedDay) {//可以用new Date().toLocalString()传递参数
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的后一天
     *
     * @param specifiedDay
     * @return
     */
    public static String getSpecifiedDayAfter(String specifiedDay) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + 1);

        String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
                .format(c.getTime());
        return dayAfter;
    }

    /**
     * 取得指定日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static String getFirstDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
        return String.valueOf(DateTimeUtils.beginOfDay(c.getTime()));
    }

    /**
     * 取得指定日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastDayOfWeek(Date date) {
        Calendar c = new GregorianCalendar();
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
        return String.valueOf(DateTimeUtils.beginOfDay(c.getTime()));
    }

    /**
     * 取得指定日期所在月的第一天
     *
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        return String.valueOf(DateTimeUtils.beginOfDay(c.getTime()));
    }

    /**
     * 取得指定日期所在月的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DATE, 1);
        c.roll(Calendar.DATE, -1);
        return String.valueOf(DateTimeUtils.beginOfDay(c.getTime()));
    }

    public static Date str2Date(String str, String format) {
        if (null != str && !"".equals(str)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date date = null;
            try {
                date = sdf.parse(str);
                return date;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static String date2Str(Date date, String format) {
        if (null != date && !"".equals(date)) {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        }
        return null;
    }

    public static String timestamp2Str(Timestamp time) {
        if (null != time && !"".equals(time)) {
            Date date = new Date(time.getTime());
            return date2Str(date, DEFAULT_FORMAT);
        }
        return null;
    }

    public static String timestamp2Str(Timestamp time,String formatter) {
        if (null != time && !"".equals(time)) {
            Date date = new Date(time.getTime());
            return date2Str(date, formatter);
        }
        return null;
    }

    public static Timestamp str2Timestamp(String str) {
        if (null != str && !"".equals(str)) {
            Date date = str2Date(str, DEFAULT_FORMAT1);
            return new Timestamp(date.getTime());
        }
        return null;
    }

    // 把指定格式的日期字符串转日期类型
    public static Calendar convToCalender(String str,String template){

        SimpleDateFormat sdf;
        Date date;
        Calendar cltResult = Calendar.getInstance();

        sdf = new SimpleDateFormat(template, Locale.getDefault());
        try {
            date = sdf.parse(str);

            cltResult.setTime(date);

        } catch (Exception ex) {
            // TODO Auto-generated catch block
            ex.printStackTrace();
        }

        return cltResult;
    }

    /**
     * 返回系统当前时间(精确到毫秒),作为一个唯一的订单编号
     *
     * @return 以yyyyMMddHHmmss为格式的当前系统时间
     */
    public static String getUserNameStr() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        Random rad = new Random();
        return df.format(date) + rad.nextInt(1000) + "";
    }

    public static String getRentalRecordId() {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat(dtLong);
        Random rad = new Random();
        return df.format(date) + rad.nextInt(1000) + "";
    }

    public static String getChargeTime(long startTime, long endTime) {
        long temp = endTime - startTime;
        long hours = temp / 1000 / 3600;                //相差小时数
        long temp2 = temp % (1000 * 3600);
        long mins = temp2 / 1000 / 60;                    //相差分钟数
        return hours + ":" + mins;
    }

    public static void main(String[] args) throws Exception {
        String DD = getChargeTime(DateTimeUtils.beginOfDay().getTime(), DateTimeUtils.endOfDay().getTime());
        Date date = new Date("2015/4/1 12:00");
    }
}
