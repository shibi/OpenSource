package com.skel.appskeleton.data.remotedb.api;

import com.skel.appskeleton.data.remotedb.dto.ModelSample;
import retrofit2.Call;
import retrofit2.http.POST;


public interface ApiService {

    @POST("users")
    Call<ModelSample> createUser();

    /**
     * ADD YOUR API BELOW
     * */
}
