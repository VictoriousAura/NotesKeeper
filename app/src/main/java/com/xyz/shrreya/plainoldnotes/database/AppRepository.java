package com.xyz.shrreya.plainoldnotes.database;

import android.content.Context;

import com.xyz.shrreya.plainoldnotes.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;

/**
 * Created by shrreya on 7/4/19.
 */
public class AppRepository {
    private static AppRepository ourInstance;
    private AppDatabase mDb;
    private Executor executor= Executors.newSingleThreadExecutor();

    public LiveData<List<NoteEntity>> mNotes;

    public static AppRepository getInstance(Context context)
    {
        if(ourInstance== null)
        {
            ourInstance= new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        mDb=AppDatabase.getInstance(context);
        mNotes = getAllNotes();
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mDb.notesDao().insertAll(SampleData.getNotes());
            }
        });
    }

    private LiveData<List<NoteEntity>> getAllNotes(){
        return mDb.notesDao().getAll();
    }
}
