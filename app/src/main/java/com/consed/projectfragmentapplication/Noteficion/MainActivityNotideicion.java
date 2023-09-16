package com.consed.projectfragmentapplication.Noteficion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.adsadsasdas2d.textin2022.R;
import com.adsadsasdas2d.textin2022.databinding.ActivityMainNotideicionBinding;

public class MainActivityNotideicion extends AppCompatActivity {
    ActivityMainNotideicionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainNotideicionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NotificationChannel channel = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    channel = new NotificationChannel("1", "myNotification", NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager manager = getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);
                }
                //
                Intent intent = new Intent(getBaseContext(), MainActivityNotideicion.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, intent, PendingIntent.FLAG_IMMUTABLE);

                NotificationCompat.Builder builder = new NotificationCompat.Builder(getBaseContext(), "1");

                builder.setContentTitle("Mustafa")
                        .setContentText("Mustafa")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setVibrate(new long[]{2000, 500, 5000})
                        .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Welcome to my notification app..."))
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);
                NotificationManagerCompat compat = NotificationManagerCompat.from(getBaseContext());
                compat.notify(1, builder.build());

            }
        }
        );


    }
}