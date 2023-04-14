package com.example.scriza.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.scriza.Repository.DataRepository;
import com.example.scriza.RepositoryModel.Example;
import com.example.scriza.RepositoryModel.Login.User;

public class DataViewModel extends AndroidViewModel {

    private DataRepository dataRepository;

    public DataViewModel(@NonNull Application application) {
        super(application);
        dataRepository = new DataRepository(application);

    }


}
