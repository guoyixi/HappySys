package com.tj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {


    /**
     * @return     获取当前时间
     */
    public static String getCurrentDate(){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        Date currentDate = new Date();
        return ft.format(currentDate);
    }

    /**
     * @return          格式化日期
     */
    public static Date getFormatDate(String date, String pattern){
        SimpleDateFormat ft = new SimpleDateFormat(pattern);
        Date date1 = new Date();
        try {
            date1 = ft.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }


    /**
     * @return          获取两个时间相差天数
     */
    public static long getQuot(String time1, String time2){
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000 / 60 / 60 / 24;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }

    /**
     * @return      返回日期 time1是否比time2大
     */
    public static boolean compare(String time1, String time2){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        boolean flag = false;
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            flag = date1.after(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }




    public static void main(String[] args) throws Exception {
        String date1 = "2019/7/20 7:55:3";
        String date2 = getCurrentDate();

        System.out.println(compare(date1,date2));

        System.out.println(date2.toString());
        long day = getQuot(date1,date2);

        System.out.println( "距离 "+date1+" 还有 "+day+" 天" );
    }

}
