package com.consed.projectfragmentapplication.servies.e2;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

public class MyIntentService2 extends IntentService {


    private static final String ACTION_FOO = "com.adsadsasdas2d.textin2022.servies.e2.action.FOO";
    private static final String ACTION_BAZ = "com.adsadsasdas2d.textin2022.servies.e2.action.BAZ";

    private static final String EXTRA_PARAM1 = "com.adsadsasdas2d.textin2022.servies.e2.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.adsadsasdas2d.textin2022.servies.e2.extra.PARAM2";

    public MyIntentService2() {
        super("MyIntentService2");
    }


    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService2.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }


    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService2.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
    }


    private void handleActionFoo(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    private void handleActionBaz(String param1, String param2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}