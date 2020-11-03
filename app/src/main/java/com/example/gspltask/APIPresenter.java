package com.example.gspltask;

import android.content.Context;
import android.widget.Toast;

import com.example.gspltask.network.APIInterface;
import com.example.gspltask.network.ConnectionDetector;
import com.example.gspltask.network.NetworkResponse;
import com.example.gspltask.network.RequestClient;
import com.example.gspltask.network.RequestTsk;
import com.example.gspltask.pojo.UserData;
import com.example.gspltask.pojo.UserDataNew;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIPresenter {

    private APIResponse apiResponse;

    public APIPresenter(APIResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    void callAPI(final Context context, String userName, String Password) {
        if(new ConnectionDetector().isNetworkConnected(context)) {
            RequestTsk tsk = new RequestTsk();
            tsk.callAPI(context, "http://182.76.152.187:44318/Biba_qc_api/api/biba/login", userName, Password, new NetworkResponse() {
                @Override
                public void result(String response) {
                    getResponse(response);
                }

                @Override
                public void error(String error) {
                    apiResponse.onServerError(error);
                }
            });
            /*Call<List<UserData>> call = new RequestClient().getClient().create(APIInterface.class).getUserData(userName, Password);
            call.enqueue(new Callback<List<UserData>>() {
                @Override
                public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                    ArrayList<UserData> userDataArrayList = (ArrayList<UserData>) response.body();
                    apiResponse.onSuccess(userDataArrayList);
                }

                @Override
                public void onFailure(Call<List<UserData>> call, Throwable t) {
                    apiResponse.onServerError(context.getString(R.string.server_error));
                }
            });*/
        } else {
            Toast.makeText(context, R.string.check_internet, Toast.LENGTH_LONG).show();
        }
    }

    private void getResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("Table");
            for(int i=0; i<jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                UserDataNew userData = new UserDataNew();
                userData.setId(jsonObject1.getString("UserId"));
                userData.setUserName(jsonObject1.getString("UserName"));
                userData.setPassword(jsonObject1.getString("Password"));
                userData.setName(jsonObject1.getString("Name"));
                userData.setRole(jsonObject1.getString("Role"));
                userData.setEmailID(jsonObject1.getString("EmailId"));
                userData.setMobileNo(jsonObject1.getString("MobileNo"));
                userData.setLoginStatus(jsonObject1.getString("LoginStatus"));
                userData.setCreationDate(jsonObject1.getString("CreationDate"));
                userData.setDepartmentId(jsonObject1.getString("DepartmentId"));

                apiResponse.onSuccess(userData);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
