package com.consed.projectfragmentapplication.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewModelPersonal extends AndroidViewModel {

    private RepositoryPersonal repository;


    public ViewModelPersonal(@NonNull Application application) {
        super(application);
        repository = new RepositoryPersonal(application);
    }

    public void InsertPersonal(Personal personal, OpRoom listener) {
        repository.InsertPersonal(personal, listener);
    }


    public void UpdatePersonal(Personal personal, OpRoom listener) {
        repository.UpdatePersonal(personal, listener);
    }


    public void DeletePersonal(Personal personal, OpRoom listener) {
        repository.DeletePersonal(personal, listener);
    }


    public LiveData<List<Personal>> getData() {
        return repository.getData();
    }

}
