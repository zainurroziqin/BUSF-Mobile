package com.example.busfmobile.api;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.busfmobile.activity.LoginActivity;
import com.example.busfmobile.activity.MainActivity;

import java.util.HashMap;

public class SessionManager {
    private  SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static final String KEY_USERNAME = "username";
    public static final String KEY_NAMA = "nama";
    private final String SHARE_NAME = "loginsession";
    private static final String is_login = "LogginStatus";
    private final int MODE_PRIVATE = 0;
    public Context _context;

    public SessionManager(Context context) {
        this._context = context;
        sp = _context.getSharedPreferences(SHARE_NAME, MODE_PRIVATE);
        editor = sp.edit();
    }
    public void storeLogin(String user, String nama){
        editor.putBoolean(is_login, true);
        editor.putString(KEY_USERNAME, user);
        editor.putString(KEY_NAMA, nama);
        editor.commit();
    }

    public HashMap getDataLogin(){
        HashMap<String, String> map = new HashMap<>();
        map.put(KEY_NAMA, sp.getString(KEY_NAMA, null));
        map.put(KEY_USERNAME, sp.getString(KEY_USERNAME, null));
        return map;
    }

    public void checkLogin(){
        if ( !this.Loggin()){
            Intent login = new Intent(_context, LoginActivity.class);
//            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            login.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            _context.startActivity(login);
            ((MainActivity)_context).finish();

        }
    }

    public boolean Loggin(){
        return sp.getBoolean(is_login, false);
    }

    public void Logout(){
        editor.clear();
        editor.commit();
    }


}
