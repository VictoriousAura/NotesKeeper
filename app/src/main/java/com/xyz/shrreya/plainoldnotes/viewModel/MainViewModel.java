package com.xyz.shrreya.plainoldnotes.viewModel;

import android.app.Application;

import com.xyz.shrreya.plainoldnotes.database.AppRepository;
import com.xyz.shrreya.plainoldnotes.database.NoteEntity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by shrreya on 6/4/19.
 */
public class MainViewModel extends AndroidViewModel {

    public LiveData<List<NoteEntity>> mNotes;
    public AppRepository mAppRepository;

    public MainViewModel(@NonNull Application application) {

        super(application);
        mAppRepository= AppRepository.getInstance(application.getApplicationContext());
        mNotes=mAppRepository.mNotes;
    }

    public void addSampleData() {
        mAppRepository.addSampleData();
    }

    public void deleteAllNotes() {
        mAppRepository.deleteAllNotes();
    }
}
