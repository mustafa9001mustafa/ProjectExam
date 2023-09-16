package com.consed.projectfragmentapplication.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.consed.projectfragmentapplication.databinding.ActivityMainActivitybroBinding;


public class MainActivitybro extends AppCompatActivity {
    ActivityMainActivitybroBinding binding;
    MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainActivitybroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
         receiver =new MyReceiver();
        // عند بداية تشغيل الهاتف
        // لازم تعمل برميشن في المين فيستت
       registerReceiver(receiver, new IntentFilter(Intent.ACTION_BOOT_COMPLETED));
       // عند تشغيل السماعة
       registerReceiver(receiver, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
        // عندما تصبح البطارية ضعيفة
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));
        // وضع الطيران
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));

    }
// مهمة عشان تطفيه
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}