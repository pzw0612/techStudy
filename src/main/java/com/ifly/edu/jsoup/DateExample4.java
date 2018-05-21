package com.ifly.edu.jsoup;

import java.text.DateFormat;
import java.util.Date;

public class DateExample4 {
    public static void main(String[] args)
    {
        Date date = new Date();

        DateFormat shortDateFormat =
                DateFormat.getDateTimeInstance(
                        DateFormat.SHORT,
                        DateFormat.SHORT);

        DateFormat mediumDateFormat =
                DateFormat.getDateTimeInstance(
                        DateFormat.MEDIUM,
                        DateFormat.MEDIUM);

        DateFormat longDateFormat =
                DateFormat.getDateTimeInstance(
                        DateFormat.LONG,
                        DateFormat.LONG);

        DateFormat fullDateFormat =
                DateFormat.getDateTimeInstance(
                        DateFormat.FULL,
                        DateFormat.FULL);

//        DateFormat fullDateFormat2 =DateFormat.getDateInstance(DateFormat.);

        System.out.println(shortDateFormat.format(date));
        System.out.println(mediumDateFormat.format(date));
        System.out.println(longDateFormat.format(date));
        System.out.println(fullDateFormat.format(date));
    }



}
