package com.example.gspltask.pojo;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserData implements Serializable {

    @SerializedName("UserId")
    public Integer id;

    @SerializedName("UserName")
    public String userName;

    @SerializedName("Password")
    public String password;

    @SerializedName("Name")
    public String name;

    @SerializedName("Role")
    public String role;

    @SerializedName("EmailId")
    public String emailID;

    @SerializedName("MobileNo")
    public Integer mobileNo;

    @SerializedName("LoginStatus")
    public Integer loginStatus;

    @SerializedName("CreationDate")
    public Integer creationDate;

    @SerializedName("DepartmentId")
    public String departmentId;
}
