package com.shuai.demo.Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {

    public static void main(String[] args) {
        String st = "2018-08-20 00:00:00";
        String et = "2018-08-20 11:59:59";
        String ot = "2018-08-20 08:00:00";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sdate = simpleDateFormat.parse(st);
            Date edate = simpleDateFormat.parse(et);
            Date odate = simpleDateFormat.parse(ot);
//            System.out.println(belongCalendar(odate,sdate,edate));
//            beforeTime();
//            System.err.println(betweenDays(simpleDateFormat.parse("2018-01-03 23:00:00"),simpleDateFormat.parse("2017-12-29 00:00:00")));
            System.out.println(isLastDayOfMonth(new Date()));
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    public static void beforeTime(){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date bt=sdf.parse("2018-01-01 00:00:02");
            Date et=sdf.parse("2018-01-01 00:00:01");
            if (bt.after(et)){
                System.out.println("bt大于et");
            }else{
                System.out.println("bt小于et");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static Long betweenDays(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(11, 0);
        fromCalendar.set(12, 0);
        fromCalendar.set(13, 0);
        fromCalendar.set(14, 0);
        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(11, 0);
        toCalendar.set(12, 0);
        toCalendar.set(13, 0);
        toCalendar.set(14, 0);
        return (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / 86400000L;
    }





    /**
     * 判断time是否在from，to之内
     *
     * @param time 指定日期
     * @param from 开始日期
     * @param to   结束日期
     * @return
     */
    public static boolean belongCalendar(Date time, Date from, Date to) {
        Calendar date = Calendar.getInstance();
        date.setTime(time);

        Calendar after = Calendar.getInstance();
        after.setTime(from);

        Calendar before = Calendar.getInstance();
        before.setTime(to);

        if (date.after(after) && date.before(before)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 判断该日期是否是该月的最后一天
     *
     * @param date
     *            需要判断的日期
     * @return
     */
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  calendar.get(Calendar.DAY_OF_MONTH) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
