package com.example.busfmobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.busfmobile.R;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private int flagExit = 0;
    TextView tvHello;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHello = findViewById(R.id.tvHello);
        Bundle extras = getIntent().getExtras();
        tvHello.setText(extras.getString("username"));
        if(extras!=null){
            setTitle(extras.getString("username"));
        }else {
            setTitle("Home");
        }

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