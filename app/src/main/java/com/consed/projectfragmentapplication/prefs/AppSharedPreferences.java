package com.consed.projectfragmentapplication.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.consed.projectfragmentapplication.appcontroller.AppControllers;


enum PrefKeys {
    id, loggedIn, email, token
}

public class AppSharedPreferences {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private AppSharedPreferences() {
        sharedPreferences = AppControllers.getInstance().getSharedPreferences("api_house", Context.MODE_PRIVATE);
    }

    private static AppSharedPreferences instance;

    public static AppSharedPreferences getInstance() {
        if (instance == null) {
            instance = new AppSharedPreferences();
        }

        return instance;
    }



    public String getToken() {
        return sharedPreferences.getString(PrefKeys.token.name(), "");
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(PrefKeys.loggedIn.name(), false);
    }

    public void clear() {
        editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public boolean isFirstTime() {
        boolean ranBeforeGame = sharedPreferences.getBoolean("RanBeforeTime", false);
        if (!ranBeforeGame) {
            editor = sharedPreferences.edit();
            editor.putBoolean("RanBeforeTime", true);
            editor.apply();
        }
        return !ranBeforeGame;
    }

    public void SetAnim(boolean b) {
        editor = sharedPreferences.edit();
        editor.putBoolean("Anim", b);
        editor.apply();
    }

    public boolean GetAnim() {
        editor = sharedPreferences.edit();
        boolean SwitchCompat_on_off_s = sharedPreferences.getBoolean("Anim", false);
        editor.apply();
        return SwitchCompat_on_off_s;
    }
}
