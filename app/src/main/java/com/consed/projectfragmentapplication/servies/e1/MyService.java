package com.consed.projectfragmentapplication.servies.e1;


import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.consed.projectfragmentapplication.R;


public class MyService extends Service {
    MediaPlayer player;

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        player = MediaPlayer.create(getApplicationContext(), R.raw.m);

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);


        NotificationChannel channel = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            channel = new NotificationChannel("2", "myNotification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        //عشان يوقف الكود لا نقول له يودينا على المين أكتيفيتي
        // بتخليه يودينا على السيرفيس الحالية
        Intent intent1 = new Intent(getBaseContext(), MyService.class);
        // هين حطينا قيمة عشان نتأكد منها تحت بس
        intent1.setAction("Stop");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getBaseContext(), 0, intent1, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "1");

        builder.setContentTitle("Mustafa")
                .setContentText("Mustafa")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setVibrate(new long[]{2000, 500, 5000})
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Welcome to my notification app..."))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat compat = NotificationManagerCompat.from(this);
        compat.notify(1, builder.build());


        startForeground(1, builder.build());
// إف عادية للتأكد من رجوع أي إنتينت
        if (intent.getAction() != null) {
            if (intent.getAction().equals("Stop")) {
                // هذي عشان أوقف السيرفيس إذا جا
                stopSelf();
            }
        }

        if (player != null) {
            player.start();
        }
        // example
        return START_NOT_STICKY;
//       return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}