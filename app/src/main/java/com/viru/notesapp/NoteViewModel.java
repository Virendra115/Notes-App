package com.viru.notesapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.viru.notesapp.database.DBHelper;
import com.viru.notesapp.database.NoteModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteViewModel extends AndroidViewModel {

    private final DBHelper dbHelper;
    private final ExecutorService executorService;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        dbHelper = DBHelper.getInstance(application);
        //To handle executing DB operations in the background then we will use the ExecutorService
        executorService = Executors.newFixedThreadPool(4);
    }

    public void insertNote(NoteModel note) {
        executorService.execute(() -> dbHelper.noteDao().insertNote(note));
    }

    public void updateNote(NoteModel note) {
        executorService.execute(() -> dbHelper.noteDao().updateNote(note));
    }

    public void deleteNote(NoteModel note) {
        executorService.execute(() -> dbHelper.noteDao().deleteNote(note));
    }

    public LiveData<List<NoteModel>> getAllNotes() {
        return dbHelper.noteDao().getAllNotes();
    }

}