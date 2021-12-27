package com.example.busfmobile.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.busfmobile.R;
import com.example.busfmobile.api.APIRequestData;
import com.example.busfmobile.api.RetroServer;
import com.example.busfmobile.api.SessionManager;
import com.example.busfmobile.model.Login;
import com.example.busfmobile.model.User;
import com.example.busfmobile.model.UserResponse;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = getClass().getSimpleName();
    private int flagExit = 0;
    TextView tvNama;
    Context context;
    CardView btnKandangA,btnKandangB,btnKandangC,btnKandangD;
    String user;
    String userImage, alamatGambar;
    ImageButton btnLogout;
    SessionManager sm;
    List<User> listGambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cheskSession();

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        HashMap<String, String> map = sm.getDataLogin();
        String adf = map.get(sm.KEY_NAMA);
        userImage = adf;
        Login.setLogin(adf);
        ImageView imageView = findViewById(R.id.imgUser);

        APIRequestData ardImage = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<UserResponse> ambilGambar = ardImage.ambilGambar(adf);

        ambilGambar.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                int kode = response.body().getCode();
                String status = response.body().getStatus();
                listGambar = response.body().getUser_list();

                alamatGambar = listGambar.get(0).getGambar();
//                Toast.makeText(MainActivity.this, "Kode : " + alamatGambar, Toast.LENGTH_SHORT).show();
//                        Glide.with(getApplicationContext()).load(alamatGambar).into(imageView);
                Picasso.get().load("https://ws-tif.com/barokah-utama-farm/assets/images/user/"+alamatGambar)
                        .placeholder(R.drawable.ic_baseline_person_24)
                        .error(R.drawable.ic_baseline_error_24)
                        .into(imageView);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "gagal Menghubungi Server", Toast.LENGTH_SHORT).show();
            }
        });

        tvNama = findViewById(R.id.tv_nama);
        String nama = Login.getLogin();
        tvNama.setText(adf);



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

    public void intentAlarm(View view) {
        Intent i = new Intent(MainActivity.this, AlarmActivity.class);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void setMode(int selectedMode) {
        switch (selectedMode){
            case R.id.action_profile:
                break;

            case R.id.action_logout:
                sm.Logout();
                sm.checkLogin();
                finish();
                break;
        }
    }
}