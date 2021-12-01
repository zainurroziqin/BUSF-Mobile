package com.example.busfmobile.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.busfmobile.R;
import com.example.busfmobile.api.APIRequestData;
import com.example.busfmobile.api.RetroServer;
import com.example.busfmobile.model.KandangDResponse;
import com.example.busfmobile.model.Login;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KandangDActivity extends AppCompatActivity {

    private EditText edtTanggal, edtPakanTotal, edtSisa1, edtSisa2, edtSisa3, edtSisa4, edtSisa5, edtSisa6,
            edtJumlahTelur, edtBeratTelur, edtJumlahMati, edtJumlahAfkir, edtSuhuPagi, edtSuhuSiang, edtSuhuSore;
    private String tanggal, pakanTotal, sisa1, sisa2, sisa3, sisa4, sisa5, sisa6, jumlahTelur, beratTelur,
            jumlahMati, jumlahAfkir, suhuPagi, suhuSiang, suhuSore, nama;
    private CheckBox cbYakin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandang_dactivity);

        edtTanggal = findViewById(R.id.edt_tanggal);
        edtPakanTotal = findViewById(R.id.totalPakan);
        edtSisa1 = findViewById(R.id.sisa1);
        edtSisa2 = findViewById(R.id.sisa2);
        edtSisa3 = findViewById(R.id.sisa3);
        edtSisa4 = findViewById(R.id.sisa4);
        edtSisa5 = findViewById(R.id.sisa5);
        edtSisa6 = findViewById(R.id.sisa6);
        edtJumlahTelur = findViewById(R.id.jumlahTelur);
        edtBeratTelur = findViewById(R.id.beratTelur);
        edtJumlahMati = findViewById(R.id.jumlahAyamMati);
        edtJumlahAfkir = findViewById(R.id.jumlahAyamAfkir);
        edtSuhuPagi = findViewById(R.id.suhuPagi);
        edtSuhuSiang = findViewById(R.id.suhuSiang);
        edtSuhuSore = findViewById(R.id.suhuSore);
        cbYakin = findViewById(R.id.cb_yakin);

        String currentDate = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());
        edtTanggal.setText(currentDate);

    }

    public void actionSimpan(View view) {
        simpan();
    }

    public void actionReset(View view) {
        reset();
    }

    private void CreateData(){
        APIRequestData ardData = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<KandangDResponse> tambahData = ardData.ardTambahDataKandangD(tanggal, pakanTotal,
                sisa1, sisa2, sisa3, sisa4, sisa5, sisa6,jumlahTelur, beratTelur, jumlahMati, jumlahAfkir,
                suhuPagi, suhuSiang, suhuSore, nama);

        tambahData.enqueue(new Callback<KandangDResponse>() {
            @Override
            public void onResponse(Call<KandangDResponse> call, Response<KandangDResponse> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(KandangDActivity.this, "Kode : " + kode +"| Pesan : " + pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<KandangDResponse> call, Throwable t) {
                Toast.makeText(KandangDActivity.this, "Gagal menghubungi server" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void reset(){
        edtPakanTotal.setText("");
        edtSisa1.setText("");
        edtSisa2.setText("");
        edtSisa3.setText("");
        edtSisa4.setText("");
        edtSisa5.setText("");
        edtSisa6.setText("");
        edtJumlahTelur.setText("");
        edtBeratTelur.setText("");
        edtJumlahMati.setText("");
        edtJumlahAfkir.setText("");
        edtSuhuPagi.setText("");
        edtSuhuSore.setText("");
        edtSuhuSiang.setText("");
    }

    private void simpan(){
        tanggal = edtTanggal.getText().toString();
        pakanTotal = edtPakanTotal.getText().toString();
        sisa1 = edtSisa1.getText().toString();
        sisa2 = edtSisa2.getText().toString();
        sisa3 = edtSisa3.getText().toString();
        sisa4 = edtSisa4.getText().toString();
        sisa5 = edtSisa5.getText().toString();
        sisa6 = edtSisa6.getText().toString();
        jumlahTelur = edtJumlahTelur.getText().toString();
        beratTelur = edtBeratTelur.getText().toString();
        jumlahMati = edtJumlahMati.getText().toString();
        jumlahAfkir = edtJumlahAfkir.getText().toString();
        suhuPagi = edtSuhuPagi.getText().toString();
        suhuSiang = edtSuhuSiang.getText().toString();
        suhuSore = edtSuhuSore.getText().toString();
        nama = Login.getLogin();

        if (pakanTotal.trim().equals("")){
            edtPakanTotal.setError("Field ini harus diisi");
        }else if (sisa1.trim().equals("")){
            edtSisa1.setError("Field ini harus diisi");
        }else if (sisa2.trim().equals("")) {
            edtSisa2.setError("Field ini harus diisi");
        }else if (sisa3.trim().equals("")) {
            edtSisa3.setError("Field ini harus diisi");
        }else if (sisa4.trim().equals("")) {
            edtSisa4.setError("Field ini harus diisi");
        }else if (sisa5.trim().equals("")) {
            edtSisa5.setError("Field ini harus diisi");
        }else if (sisa6.trim().equals("")) {
            edtSisa6.setError("Field ini harus diisi");
        }else if (jumlahTelur.trim().equals("")) {
            edtJumlahTelur.setError("Field ini harus diisi");
        }else if (beratTelur.trim().equals("")) {
            edtBeratTelur.setError("Field ini harus diisi");
        }else if (jumlahMati.trim().equals("")) {
            edtJumlahMati.setError("Field ini harus diisi");
        }else if (jumlahAfkir.trim().equals("")) {
            edtJumlahAfkir.setError("Field ini harus diisi");
        }else if (suhuPagi.trim().equals("")) {
            edtSuhuPagi.setError("Field ini harus diisi");
        }else if (suhuSiang.trim().equals("")) {
            edtSuhuSiang.setError("Field ini harus diisi");
        }else if (suhuSore.trim().equals("")) {
            edtSuhuSore.setError("Field ini harus diisi");
        }else {
            if (cbYakin.isChecked()){
                CreateData();
            }else {
                new AlertDialog.Builder(KandangDActivity.this)
                        .setTitle("Peringatan")
                        .setMessage("Anda harus mengisi centang yakin")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        }
    }
}