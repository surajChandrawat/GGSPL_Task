package com.example.gspltask.pojo;


import java.io.Serializable;

public class UserDataNew implements Serializable {

    public String id;
    public String userName;
    public String password;
    public String name;
    public String role;
    public String emailID;
    public String mobileNo;
    public String loginStatus;
    public String creationDate;
    public String departmentId;

    public UserDataNew() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getRole() {
        return role;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
