package com.example.busfmobile.activity;

import static org.junit.Assert.*;

import android.util.Log;

import com.example.busfmobile.api.APIRequestData;
import com.example.busfmobile.model.User;
import com.example.busfmobile.model.UserResponse;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivityTest {

    @Test
    public void testAdd(){
        double result = 20 + 5;
        assertTrue(result == 25);
    }

    @Test
    public void login() {
        String username = "Roziqin";
        String password = "1234";
        String[] status = new String[1];

        String globalURL = "http://10.219.124.148/";
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(globalURL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        APIRequestData client = retrofit.create(APIRequestData.class);
        Call<UserResponse> call = client.login(username, password);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body()!=null){
                    if (response.body().getCode() == 200){
                        status[0] = response.body().getStatus();


                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

        assertEquals("Sukses", status[0]);

    }

}