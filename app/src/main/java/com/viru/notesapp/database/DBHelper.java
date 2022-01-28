package com.viru.notesapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.viru.notesapp.Constants;

@Database(entities = {NoteModel.class}, version = 1,exportSchema = false)
public abstract class DBHelper extends RoomDatabase {

    private static DBHelper instance;

    public static DBHelper getInstance(Context context) {
        if (instance == null) {
            instance = Room
                    .databaseBuilder(context, DBHelper.class, Constants.DATABASE_NAME)
                    .build();
        }
        return instance;
    }
    public abstract NoteDao noteDao();

}