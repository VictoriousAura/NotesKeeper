package com.xyz.shrreya.plainoldnotes.database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by shrreya on 6/4/19.
 */
@Dao
public interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNode(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NoteEntity> notes);

    @Delete
    void deleteNode(NoteEntity noteEntity);

    @Query("SELECT * from notes where id = :id")
    NoteEntity getNotesById(int id);

    @Query("SELECT * from notes ORDER BY date DESC")
    LiveData<List<NoteEntity>> getAll();

    @Query("SELECT COUNT(*) FROM notes")
    int getAllNotes();

    @Query("DELETE from notes")
    int deleteAllNotes();
}
