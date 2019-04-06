package com.xyz.shrreya.plainoldnotes;

import android.content.Context;
import android.util.Log;

import com.xyz.shrreya.plainoldnotes.database.AppDatabase;
import com.xyz.shrreya.plainoldnotes.database.NoteEntity;
import com.xyz.shrreya.plainoldnotes.database.NotesDao;
import com.xyz.shrreya.plainoldnotes.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import static org.junit.Assert.*;

/**
 * Created by shrreya on 6/4/19.
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG= "JUnit";
    private AppDatabase mDB;
    private NotesDao mDao;

    @Before
    public void createDB(){
        Context context= InstrumentationRegistry.getTargetContext();
        mDB= Room.inMemoryDatabaseBuilder(context,AppDatabase.class).build();
        mDao= mDB.notesDao();
        Log.i(TAG,"createDb");
    }

    @After
    public void closeDb(){
        mDB.close();
        Log.i(TAG,"closeDB");
    }

    @Test
    //should be void and have no argumemts
    public void createAndRetrieveNotes(){
        mDao.insertAll(SampleData.getNotes());
        int count= mDao.getAllNotes();
        Log.i(TAG,"createAndRetrieveDb count ="+ count);
        assertEquals(SampleData.getNotes().size(),count);
    }

    @Test
    public void compareStrings(){
        mDao.insertAll(SampleData.getNotes());
        NoteEntity original= SampleData.getNotes().get(0);
        NoteEntity fromDb = mDao.getNotesById(1);
        assertEquals(original.getText(), fromDb.getText());
    }

}
