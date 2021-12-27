package com.example.busfmobile.api;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionPreferences {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public SessionPreferences(Context context){
        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    public void setLogin(Boolean login){
        editor.putBoolean("KET_LOGIN", login);
        editor.commit();
    }

    public boolean getLogin(){
        return sharedPreferences.getBoolean("KET_LOGIN", false);
    }

    public void setUsername(String username){
        editor.putString("KEY_USERNAME",username);
        editor.commit();
    }

    public String getUsername(){
        return sharedPreferences.getString("KEY_USERNAME", "");
    }
}
