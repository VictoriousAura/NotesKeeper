package com.xyz.shrreya.plainoldnotes.utilities;

import com.xyz.shrreya.plainoldnotes.database.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by shrreya on 5/4/19.
 */
public class SampleData {

    private static final String SAMPLE_TEXT_1= "A Simple Note";
    private static final String SAMPLE_TEXT_2="A Note with a\nline feed";
    private static final String SAMPLE_TEXT_3="This is just another sample text";

    private static Date getDate(int diff){
        GregorianCalendar cal =new GregorianCalendar();
        cal.add(Calendar.MILLISECOND, diff);
        return cal.getTime();

    }

    public static List<NoteEntity> getNotes(){
        List<NoteEntity> notes= new ArrayList<>();
        notes.add(new NoteEntity(1,SAMPLE_TEXT_1,getDate(0)));
        notes.add(new NoteEntity(2,SAMPLE_TEXT_2,getDate(-1)));
        notes.add(new NoteEntity(3,SAMPLE_TEXT_3,getDate(-2)));
        return notes;
    }
}