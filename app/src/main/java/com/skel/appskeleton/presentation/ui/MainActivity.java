package com.skel.appskeleton.presentation.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.skel.appskeleton.R;
import com.skel.appskeleton.data.remotedb.api.ApiGenerator;
import com.skel.appskeleton.data.remotedb.api.ApiService;
import com.skel.appskeleton.data.remotedb.dto.ModelSample;
import com.skel.appskeleton.domain.Config;
import com.skel.appskeleton.domain.base.BaseActivity;
import com.skel.appskeleton.domain.utils.AppDialogs;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    @Override
    public int setContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initializeView() {

        //Sample api call for tutorial
        createSampleUser("Ash","emails@gmail.com");

    }

    private void createSampleUser(String username,String password){

        ApiService apiService = ApiGenerator.createApiService(ApiService.class, Config.ENCRYPTED_API_KEY);
        Call<ModelSample> call = apiService.createUser();

        ApiGenerator.enqueueApiCall(call, new ApiGenerator.APIResponseListener<ModelSample>(){

            @Override
            public void onSuccess(Response<ModelSample> response) {
                showToast("Api success");
                AppDialogs successDialog = new AppDialogs(MainActivity.this);
                successDialog.showAlert("Sucess", "API call success", new AppDialogs.OnSingleActionButtonClickListener() {
                    @Override
                    public void onClickClose(String close) {

                    }
                });
            }

            @Override
            public void onFailure(ApiGenerator.API_ERROR api_error, String error) {
                showToast("Api failed. "+error);
            }
        });

    }
}