package com.example.InnDB.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTool {

    public static String getNow(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        return localDateTime.format(dtf);
    }

}
