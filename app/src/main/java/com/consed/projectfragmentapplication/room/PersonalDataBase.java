package com.consed.projectfragmentapplication.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Personal.class}, version = 1, exportSchema = false)
public abstract class PersonalDataBase extends RoomDatabase {

    public abstract DaoPersonal daoParsonal();

    private static volatile PersonalDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static PersonalDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersonalDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PersonalDataBase.class, "personal_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
