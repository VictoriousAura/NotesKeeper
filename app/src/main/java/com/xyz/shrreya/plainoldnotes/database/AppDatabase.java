package com.xyz.shrreya.plainoldnotes.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * Created by shrreya on 6/4/19.
 */
@Database(entities = NoteEntity.class,version = 1)
@TypeConverters(DateConvertor.class)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME= "AppDatabase.db";
    private static volatile AppDatabase instance;
    private static final Object Lock= new Object(); //for syncronization

    public abstract NotesDao notesDao();

    public static AppDatabase getInstance(Context context) {
        if(instance == null)
        {
            synchronized (Lock) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
                }
            }
        }
        return instance;
    }
}
