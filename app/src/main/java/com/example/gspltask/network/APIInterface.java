package com.example.gspltask.network;

import com.example.gspltask.pojo.UserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/api/biba/login")
    Call<List<UserData>> getUserData(@Header("username") String userName, @Header("password") String password);
}
