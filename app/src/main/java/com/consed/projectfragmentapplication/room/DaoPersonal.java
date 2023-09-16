package com.consed.projectfragmentapplication.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DaoPersonal {
    @Insert
    long InsertData(Personal parsonal);

    @Update
    int UpdateData(Personal parsonal);


    @Delete
    void DeleteData(Personal parsonal);

    @Query("select * from Personal")
    LiveData<List<Personal>> getData();
}
