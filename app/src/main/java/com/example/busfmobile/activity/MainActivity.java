package com.example.busfmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busfmobile.R;
import com.example.busfmobile.api.SessionManager;
import com.example.busfmobile.model.Login;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();
    private int flagExit = 0;
    TextView tvNama;
    CardView btnKandangA,btnKandangB,btnKandangC,btnKandangD;
    String user;
    ImageButton btnLogout;
    SessionManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cheskSession();
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        HashMap<String, String> map = sm.getDataLogin();
//        String adf = map.get(sm.KEY_NAMA);

//        if (adf.equals("")){
//            finish();
//
//        }

//
//        getSupportActionBar().setTitle("BUSF");
//        toolbar.setSubtitle("Barokah utama");
//        toolbar.setLogo(R.drawable.ic_baseline_menu_24);
//
        tvNama = findViewById(R.id.tv_nama);
        String nama = Login.getLogin();
        tvNama.setText(nama);

        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.Logout();
                sm.checkLogin();
                finish();
            }
        });


        btnKandangA = findViewById(R.id.btnKandangA);
        btnKandangB = findViewById(R.id.btnKandangB);
        btnKandangC = findViewById(R.id.btnKandangC);
        btnKandangD = findViewById(R.id.btnKandangD);
        btnKandangA.setOnClickListener(this);
        btnKandangB.setOnClickListener(this);
        btnKandangC.setOnClickListener(this);
        btnKandangD.setOnClickListener(this);
//        if(extras!=null){
//            setTitle(extras.getString("username"));
//        }else {
//            setTitle("Home");
//        }

    }

    @Override
    public  void onBackPressed(){
        flagExit++;
        if(flagExit ==2){
            super.onBackPressed();
        }else {
            Toast.makeText(this, "Tekan lagi untuk keluar", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        int id;
        id = v.getId();
        switch (id){
            case R.id.btnKandangA:
                Intent intentA = new Intent(this, KandangAActivity.class);
                intentA.putExtra("user", user);
                startActivity(intentA);
                break;
            case R.id.btnKandangB:
                Intent intentB = new Intent(this, KandangBActivity.class);
                intentB.putExtra("user", user);
                startActivity(intentB);
                break;
            case R.id.btnKandangC:
                Intent intentC = new Intent(this, KandangCActivity.class);
                intentC.putExtra("user", user);
                startActivity(intentC);
                break;
            case R.id.btnKandangD:
                Intent intentD = new Intent(this, KandangDActivity.class);
                intentD.putExtra("user", user);
                startActivity(intentD);
                break;
        }
    }

    private void cheskSession(){
        sm = new SessionManager(MainActivity.this);
        sm.checkLogin();
    }

//    public void checkLogin(){
//        if (!SessionManager.Loggin()){
//            Intent login = new Intent(MainActivity.this, LoginActivity.class);
////            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
////            login.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////            login.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(login);
//            finish();
//
//        }
//    }
}