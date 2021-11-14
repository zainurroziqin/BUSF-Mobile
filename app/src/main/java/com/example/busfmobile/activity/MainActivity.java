package com.example.busfmobile.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busfmobile.R;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private int flagExit = 0;
    TextView tvNama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        getSupportActionBar().setTitle("BUSF");
//        toolbar.setSubtitle("Barokah utama");
//        toolbar.setLogo(R.drawable.ic_baseline_menu_24);
//
        tvNama = findViewById(R.id.tv_nama);
        Bundle extras = getIntent().getExtras();
        tvNama.setText(extras.getString("username"));
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

}