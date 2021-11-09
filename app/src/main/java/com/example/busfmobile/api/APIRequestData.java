package com.example.busfmobile.api;

import com.example.busfmobile.model.User;
import com.example.busfmobile.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRequestData {
    @GET("BarokahUtama/Login.php")
    Call<UserResponse> login(@Query("username") String username, @Query("password") String password);
}
