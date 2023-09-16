package com.consed.projectfragmentapplication.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "start", Toast.LENGTH_SHORT).show();
        if (intent.getAction().equals(Intent.ACTION_BATTERY_LOW)){
            Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
        }else {
            int x = Settings.System.getInt(context.getContentResolver(),Settings.Global.AIRPLANE_MODE_ON,-1);
            if (x == 0){
                Toast.makeText(context, "on", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(context, "off", Toast.LENGTH_SHORT).show();
            }
        }

//لو في 2 أكشن هذا الي بسويه


        // لما يكون عندي كود بيأخذ وقت طويل بعمل عملية الإنتظار وهي مهمة جدا

//        PendingResult result = goAsync();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10000);
//                    result.finish();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        throw new UnsupportedOperationException("Not yet implemented");


    }
}