package com.xyz.shrreya.plainoldnotes.viewModel;

import android.app.Application;

import com.xyz.shrreya.plainoldnotes.database.NoteEntity;
import com.xyz.shrreya.plainoldnotes.utilities.SampleData;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
/**
 * Created by shrreya on 6/4/19.
 */
public class MainViewModel extends AndroidViewModel {

    public List<NoteEntity> mNotes = SampleData.getNotes();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
