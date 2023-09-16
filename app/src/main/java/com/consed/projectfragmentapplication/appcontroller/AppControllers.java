package com.consed.projectfragmentapplication.appcontroller;
import android.app.Application;


public class AppControllers extends Application {
    private static AppControllers instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static AppControllers getInstance()   {
        return instance;
    }
}