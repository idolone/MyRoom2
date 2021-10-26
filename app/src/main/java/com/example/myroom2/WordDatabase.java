package com.example.myroom2;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class},version = 1,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static WordDatabase instance;
    public static synchronized WordDatabase getInstance(Context context){
        if(instance == null){
           instance = Room.databaseBuilder(context,WordDatabase.class,"word_db1")
                      .build();
        }
        return instance;
    }
    public abstract WordDao getWordDao();
}
