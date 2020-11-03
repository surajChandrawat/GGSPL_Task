package com.example.gspltask;

import android.os.Bundle;
import android.widget.TextView;

import com.example.gspltask.pojo.UserData;
import com.example.gspltask.pojo.UserDataNew;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NextActivity extends AppCompatActivity {

    private TextView tv_id,tv_userName,tv_password,tv_name,tv_role,tv_emailId,tv_mobileNo,tv_status,tv_date,tv_deptID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        init();
    }

    private void init() {
        tv_id = findViewById(R.id.tv_id);
        tv_userName = findViewById(R.id.tv_userName);
        tv_password = findViewById(R.id.tv_password);
        tv_name = findViewById(R.id.tv_name);
        tv_role = findViewById(R.id.tv_role);
        tv_emailId = findViewById(R.id.tv_emailId);
        tv_mobileNo = findViewById(R.id.tv_mobileNo);
        tv_status = findViewById(R.id.tv_status);
        tv_date = findViewById(R.id.tv_date);
        tv_deptID = findViewById(R.id.tv_deptID);

        UserDataNew userDataNew = (UserDataNew) getIntent().getSerializableExtra("userData");
        tv_id.setText(userDataNew.getId());
        tv_userName.setText(userDataNew.getUserName());
        tv_password.setText(userDataNew.getPassword());
        tv_name.setText(userDataNew.getName());
        tv_role.setText(userDataNew.getRole());
        tv_emailId.setText(userDataNew.getEmailID());
        tv_mobileNo.setText(userDataNew.getMobileNo());
        tv_status.setText(userDataNew.getLoginStatus());
        tv_date.setText(userDataNew.getCreationDate());
        tv_deptID.setText(userDataNew.getDepartmentId());
    }
}
