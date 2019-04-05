package com.xyz.shrreya.plainoldnotes.database;

import java.util.Date;

import androidx.room.TypeConverter;

/**
 * Created by shrreya on 6/4/19.
 */
public class DateConvertor {

    @TypeConverter
    public static Long toLongTimeStamp(Date date){
        return date == null? null: date.getTime();
    }

    @TypeConverter
    public static Date toDate(Long timestamp){
        return timestamp == null?null: new Date(timestamp);
    }
}
