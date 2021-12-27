package com.example.busfmobile.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroServer {
    private static final String baseURL = "https://ws-tif.com/barokah-utama-farm/API/";
    private static Retrofit retro;

    public static Retrofit konekRetrofit(){
        if (retro==null){
            retro = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}
