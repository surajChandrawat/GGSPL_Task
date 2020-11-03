package com.example.gspltask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gspltask.pojo.UserData;
import com.example.gspltask.pojo.UserDataNew;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, APIResponse {

    private EditText et_userName,et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        findViewById(R.id.bt_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.bt_login) {
            checkValidation();
        }
    }

    private void checkValidation() {
        String userName = et_userName.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        if(userName.isEmpty()) {
            Toast.makeText(this,"Please Enter UserName", Toast.LENGTH_LONG).show();
        } else if(password.isEmpty()) {
            Toast.makeText(this,"Please Enter Password", Toast.LENGTH_LONG).show();
        } else {
            APIPresenter presenter = new APIPresenter(this);
            presenter.callAPI(this, userName, password);
        }
    }

    @Override
    public void onSuccess(Object object) {
        Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
        UserDataNew userDataNew = (UserDataNew) object;
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("userData", userDataNew);
        startActivity(intent);
    }

    @Override
    public void onServerError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}