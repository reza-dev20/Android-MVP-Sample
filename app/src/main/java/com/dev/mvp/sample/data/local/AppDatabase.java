package com.dev.mvp.sample.data.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dev.mvp.sample.data.local.dao.TaskDao;
import com.dev.mvp.sample.data.model.Task;

@Database(entities = {Task.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase==null)
            appDatabase= Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"db_app")
                    .allowMainThreadQueries()
                    .build();

        return appDatabase;
    }
    public abstract TaskDao getTaskDao();
}
