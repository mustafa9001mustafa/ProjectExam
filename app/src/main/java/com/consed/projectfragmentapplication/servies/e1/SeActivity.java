package com.consed.projectfragmentapplication.servies.e1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.consed.projectfragmentapplication.databinding.ActivitySeBinding;


public class SeActivity extends AppCompatActivity {
    ActivitySeBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        //
        //
        //
        // نقطة مهمة جدا حتى يشتغل معك التطبيق بشكل صحيح ضيف البرميشن في المينفيست
        //
        //
        //
        //
        binding.btnStartSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), MyService.class);

                // عشان نشغل الإشعار
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startForegroundService(intent);
                } else {

                    // الإصدارات  القديمة
                    ContextCompat.startForegroundService(getBaseContext(), intent);
                }

                // service normal تشغيل السيرفيس العادية
//                startService(intent);
            }
        });

        binding.btnFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // service normal تشغيل السيرفيس العادية
//                stopService(intent);

            }
        });
    }
}