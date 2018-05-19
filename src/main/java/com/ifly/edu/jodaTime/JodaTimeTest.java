package com.ifly.edu.jodaTime;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/5/16
 **/
public class JodaTimeTest {
    public static void main(String[] args) {

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

    }
}

