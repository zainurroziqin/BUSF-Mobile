package com.example.busfmobile.api;

import com.example.busfmobile.model.KandangAResponse;
import com.example.busfmobile.model.KandangBResponse;
import com.example.busfmobile.model.KandangCResponse;
import com.example.busfmobile.model.KandangDResponse;
import com.example.busfmobile.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("Login.php")
    Call<UserResponse> login(@Query("username") String username, @Query("password") String password);

    @FormUrlEncoded
    @POST("CRUD_KandangA/tambah_data.php")
    Call<KandangAResponse> ardTambahDataKandangA(
            @Field("tanggal") String tanggal,
            @Field("pakan_total") String pakan_total,
            @Field("sisa_1") String sisa_1,
            @Field("sisa_2") String sisa_2,
            @Field("sisa_3") String sisa_3,
            @Field("sisa_4") String sisa_4,
            @Field("sisa_5") String sisa_5,
            @Field("sisa_6") String sisa_6,
            @Field("jumlah_telur") String jumlah_telur,
            @Field("berat_telur") String berat_telur,
            @Field("mati") String mati,
            @Field("afkir") String afkir,
            @Field("suhu_pagi") String suhu_pagi,
            @Field("suhu_siang") String suhu_siang,
            @Field("suhu_sore") String suhu_sore,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("CRUD_KandangB/tambah_data.php")
    Call<KandangBResponse> ardTambahDataKandangB(
            @Field("tanggal") String tanggal,
            @Field("pakan_total") String pakan_total,
            @Field("sisa_1") String sisa_1,
            @Field("sisa_2") String sisa_2,
            @Field("sisa_3") String sisa_3,
            @Field("sisa_4") String sisa_4,
            @Field("sisa_5") String sisa_5,
            @Field("sisa_6") String sisa_6,
            @Field("jumlah_telur") String jumlah_telur,
            @Field("berat_telur") String berat_telur,
            @Field("mati") String mati,
            @Field("afkir") String afkir,
            @Field("suhu_pagi") String suhu_pagi,
            @Field("suhu_siang") String suhu_siang,
            @Field("suhu_sore") String suhu_sore,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("CRUD_KandangC/tambah_data.php")
    Call<KandangCResponse> ardTambahDataKandangC(
            @Field("tanggal") String tanggal,
            @Field("pakan_total") String pakan_total,
            @Field("sisa_1") String sisa_1,
            @Field("sisa_2") String sisa_2,
            @Field("sisa_3") String sisa_3,
            @Field("sisa_4") String sisa_4,
            @Field("sisa_5") String sisa_5,
            @Field("sisa_6") String sisa_6,
            @Field("jumlah_telur") String jumlah_telur,
            @Field("berat_telur") String berat_telur,
            @Field("mati") String mati,
            @Field("afkir") String afkir,
            @Field("suhu_pagi") String suhu_pagi,
            @Field("suhu_siang") String suhu_siang,
            @Field("suhu_sore") String suhu_sore,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("CRUD_KandangD/tambah_data.php")
    Call<KandangDResponse> ardTambahDataKandangD(
            @Field("tanggal") String tanggal,
            @Field("pakan_total") String pakan_total,
            @Field("sisa_1") String sisa_1,
            @Field("sisa_2") String sisa_2,
            @Field("sisa_3") String sisa_3,
            @Field("sisa_4") String sisa_4,
            @Field("sisa_5") String sisa_5,
            @Field("sisa_6") String sisa_6,
            @Field("jumlah_telur") String jumlah_telur,
            @Field("berat_telur") String berat_telur,
            @Field("mati") String mati,
            @Field("afkir") String afkir,
            @Field("suhu_pagi") String suhu_pagi,
            @Field("suhu_siang") String suhu_siang,
            @Field("suhu_sore") String suhu_sore,
            @Field("nama") String nama
    );

    @FormUrlEncoded
    @POST("getImage.php")
    Call<UserResponse> ambilGambar(
            @Field("nama") String nama
    );
}
