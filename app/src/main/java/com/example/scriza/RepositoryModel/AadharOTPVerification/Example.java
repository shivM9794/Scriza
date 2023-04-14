package com.example.scriza.RepositoryModel.AadharOTPVerification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("api_id")
    @Expose
    private Integer apiId;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, Data data, Integer apiId, String message) {
        this.statusId = statusId;
        this.data = data;
        this.apiId = apiId;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Integer getApiId() {
        return apiId;
    }

    public void setApiId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
