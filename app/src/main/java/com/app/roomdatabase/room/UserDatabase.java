package com.app.roomdatabase.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * RoomDatabase class
 */
@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {
    public static UserDatabase instance = null;
    public abstract UserDao userDao();

    public static synchronized UserDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context, UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
