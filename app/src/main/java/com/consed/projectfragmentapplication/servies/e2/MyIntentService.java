package com.consed.projectfragmentapplication.servies.e2;

import android.app.IntentService;
import android.content.Intent;
import android.widget.Toast;


public class MyIntentService extends IntentService {



    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(this, "hi", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "bey", Toast.LENGTH_SHORT).show();

    }
}