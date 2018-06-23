package com.ifly.edu.jodaTime;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/5/16
 **/
public class JodaTimeTest {
    public static void main(String[] args) {


        //'2018-05-20 10:00:01',	'2018-05-21 06:00:01'  hft_withdrawal_deposit_view_model_cube
        System.out.println(dateParese("2018-05-20 10:00:01"));
        System.out.println(dateParese("2018-05-21 06:00:02"));
        System.out.println("----");
        //'2018-05-21 06:00:02',	'2018-05-21 08:00:02'  user_login_log_view_model_cube
        System.out.println(dateParese("2018-05-21 05:00:03"));
        System.out.println(dateParese("2018-05-21 06:00:02"));
        System.out.println("----");
        //'2018-05-20 14:00:01',	'2018-05-21 14:00:02'  hft_user_order_view_by_day_cube
        System.out.println(dateParese("2018-05-20 14:00:01"));
        System.out.println(dateParese("2018-05-21 14:00:02"));
        System.out.println("----");


        System.out.println(dateParese("2018-05-21 06:00:00"));



        System.out.println(dateParese("2018-05-30 00:00:00"));

        cubeSegment();

        System.out.println("----");
        System.out.println(dateParese("2017-09-17 00:00:01"));
        System.out.println(dateParese("2018-01-05 00:00:01"));
        System.out.println(dateParese("2018-05-28 10:55:18"));

        System.out.println("----");
        DateTime date_range_start8 = new DateTime(dateParese("2018-05-28 10:55:18"));
        date_range_start8=date_range_start8.plusHours(8);

        System.out.println("date_range_start8:"+ date_range_start8.getMillis());
//        String date="2018-05-21 14:00:01";
//        System.out.println("\"2018-05-21 14:00:01="+dateParese(date));

        //DateTime tt =new DateTime(dateParese("2018-05-21 06:00:00"),DateTimeZone.forID("CST"));


//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
//        Date date = new Date(1391174450000L); // 2014-1-31 21:20:50
//        calendar.setTime(date);
//
//        System.out.println("date = [" + date + "]");
//        DateTime tt =new DateTime(calendar.getTime(),DateTimeZone.forID("GMT"));
//        System.out.println("tt = [" + tt + "]");

    }


    public static  void dateParese(){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy",Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = null;
        try {
            d2 = sdf.parse("May 20, 2018");

            System.out.println("d2="+ sdf2.format(d2));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static  long dateParese(String datestr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = null;
        try {
            d2 = sdf.parse(datestr);
            return d2.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static void cubeSegment(){

        DateTime last_modified = new DateTime(1526459463599l);
        System.out.println("last_modified = "+last_modified.toString("yyyyMMdd HH:mm:ss"));

        DateTime date_range_start = new DateTime(1504224000000l);
        System.out.println("date_range_start = "+date_range_start.toString("yyyyMMdd HH:mm:ss"));

        DateTime date_range_end = new DateTime(1506729600000l);
        System.out.println("date_range_end = "+date_range_end.toString("yyyyMMdd HH:mm:ss"));


        DateTime date_range_start2 = new DateTime(1506729600000l);
        System.out.println("date_range_start = "+date_range_start2.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end2  = new DateTime(1507334400000l);
        System.out.println("date_range_end = "+date_range_end2.toString("yyyyMMdd HH:mm:ss"));

        DateTime create_time_utc  = new DateTime(1525993594353l);
        System.out.println("create_time_utc = "+create_time_utc.toString("yyyyMMdd HH:mm:ss"));




        DateTime date_range_start3 = new DateTime(1507334400000l);
        System.out.println("date_range_start3 = "+date_range_start3.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end3  = new DateTime(1507420800000l);
        System.out.println("date_range_end3 = "+date_range_end3.toString("yyyyMMdd HH:mm:ss"));



        DateTime date_range_start4 = new DateTime(1507420800000l);
        System.out.println("date_range_start4 = "+date_range_start4.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end4  = new DateTime(1507507200000l);
        System.out.println("date_range_end4 = "+date_range_end4.toString("yyyyMMdd HH:mm:ss"));


        DateTime date_range_start5 = new DateTime(1507507200000l);
        System.out.println("date_range_start5 = "+date_range_start5.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end5  = new DateTime(1507593600000l);
        System.out.println("date_range_end5 = "+date_range_end5.toString("yyyyMMdd HH:mm:ss"));


        DateTime date_range_start6 = new DateTime(1507593600000l);
        System.out.println("date_range_start6 = "+date_range_start6.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end6  = new DateTime(1507681800000l);
        System.out.println("date_range_end6 = "+date_range_end6.toString("yyyyMMdd HH:mm:ss"));


        String currentSegmentStartTimeReq = new DateTime(new Date()).plusHours(8).toString("yyyyMMdd HH:mm:ss");
        System.out.println("currentSegmentStartTimeReq = "+currentSegmentStartTimeReq);



        DateTime date_range_start7 = new DateTime(1526796000000l);
        System.out.println("date_range_start7 = "+date_range_start7.toString("yyyyMMdd HH:mm:ss"));
        DateTime date_range_end7  = new DateTime(1526810400005l);
        System.out.println("date_range_end7 = "+date_range_end7.toString("yyyyMMdd HH:mm:ss"));

        System.out.println("ms="+ date_range_end7.getMillis());

        //2018-05-20 08:00:01

        //DateTime date_range_start8 = DateTime.parse("2018-05-20 08:00:01");
        //date_range_start8=date_range_start8.plus(0);
        //System.out.println("date_range_start8 = "+date_range_start8.toString("yyyyMMdd HH:mm:ss"));

        System.out.println("--------------");

        dateParese();


        DateTime date_range_end8  = new DateTime(1526882539558l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));


        date_range_end8  = new DateTime(1526902200035l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));



        //1526853602000_1526976000211
         date_range_end8  = new DateTime(1526853602000l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));


        date_range_end8  = new DateTime(1526976000211l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));


        date_range_end8  = new DateTime(1526853602000l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));

        date_range_end8  = new DateTime(1526983200792l);
        System.out.println("date_range_end8 = "+date_range_end8.toString("yyyyMMdd HH:mm:ss SSS"));
//        long currentSegmentStartTime;
//        DateTime dt =new DateTime(1526853602000l).plusHours(0);
//        System.out.println("dt = "+dt.toString("yyyyMMdd HH:mm:ss SSS"));



    }


    //T代表后面跟着时间，Z代表UTC统一时间
    String tpTme = "2014-11-11T14:00:00+0800";
    String pmTime = "2014-11-07T14:00:00Z";


    public void testTPTime() throws Exception {
//2014-11-11T14:00:00+08:00
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        String time = format.format(new Date());
        System.out.println(time);

    }

    public void testPMTime() throws Exception {
//2014-11-07T14:00:00Z
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String time = format.format(new Date());
        System.out.println(time);
    }

    //转换回来

    public void testParsePMTime() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date time = df.parse(pmTime);
        System.out.println(time);
    }

    //转换回来

    public void testParseTPTime() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        Date time = df.parse(tpTme);
        System.out.println(time);
    }
}

