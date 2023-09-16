package com.consed.projectfragmentapplication.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RepositoryPersonal {

    DaoPersonal daoPersonal;

    public RepositoryPersonal(Application application) {
        PersonalDataBase db  = PersonalDataBase.getDatabase(application);
        daoPersonal = db.daoParsonal();
    }


    public void InsertPersonal(Personal personal , OpRoom opRoom) {
        PersonalDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoPersonal.InsertData(personal);
                opRoom.insert();

            }
        });
    }



    public void UpdatePersonal(Personal personal , OpRoom opRoom) {
        PersonalDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoPersonal.UpdateData(personal);
                opRoom.Update(personal);

            }
        });
    }


    public void DeletePersonal(Personal personal , OpRoom opRoom) {
        PersonalDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                daoPersonal.DeleteData(personal);
            }
        });
    }


    public LiveData<List<Personal>> getData() {
        return daoPersonal.getData();
    }

}
