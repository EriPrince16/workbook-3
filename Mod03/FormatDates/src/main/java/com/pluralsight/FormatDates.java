package com.pluralsight;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.time.LocalDate;


public class FormatDates {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate date = LocalDate.now();
        System.out.println(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        System.out.println(date.format(formatter));

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm");
        System.out.println(dateTime.format(fmt));

//        LocalDate date = LocalDate.now();
//
//        System.out.println("Day of Week: " + date.getDayOfWeek());
//        System.out.println("Day of Month: " + date.getDayOfMonth());
//        System.out.println("Day of Year: " + date.getDayOfYear());
//        System.out.println("Month Name: " + date.getMonth());
//        System.out.println("Month Value: " + date.getMonthValue());
//        System.out.println("Year: " + date.getYear());



//        LocalTime time = LocalTime.now();

//        System.out.println("Hours: " + time.getHour());
//        System.out.println("Minutes: " + time.getMinute());
//        System.out.println("Second: " + time.getSecond());
//        System.out.println("Nanosecond: " + time.getNano());

//        LocalDateTime today = LocalDateTime.now();
//        System.out.println("Today is: " + today);
//
////        // Specify the date/time format you will want to use
////        DateTimeFormatter fmt =
////                DateTimeFormatter.ofPattern("E, MMM dd, yyyyy HH:mm:ss");
////
////        String formattedDate = today.format(fmt);
////        System.out.println("Today is " + formattedDate);
//

    }
}
