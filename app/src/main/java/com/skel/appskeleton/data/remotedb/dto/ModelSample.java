
package com.skel.appskeleton.data.remotedb.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ModelSample {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
