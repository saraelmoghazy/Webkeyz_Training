package com.webkeyz.batchtwotraining.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.webkeyz.batchtwotraining.models.User;

@Database(entities = User.class, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "users_db";
    private static UserDatabase instance;

    public static UserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext()
                    , UserDatabase.class
                    , DATABASE_NAME)
                    .build();
        }
        return instance;
    }

    public abstract UserDao getUserDao();
}
