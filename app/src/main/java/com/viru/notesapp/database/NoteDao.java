package com.viru.notesapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NoteDao {
    @Insert
    void insertNote(NoteModel note);

    @Update
    void updateNote(NoteModel note);

    @Delete
    void deleteNote(NoteModel note);

    @Query("SELECT * FROM note")
    LiveData<List<NoteModel>> getAllNotes();

}
