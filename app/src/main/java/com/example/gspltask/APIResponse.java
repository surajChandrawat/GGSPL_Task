package com.example.gspltask;

public interface APIResponse {

    void onSuccess(Object object);
    void onServerError(String error);
}
