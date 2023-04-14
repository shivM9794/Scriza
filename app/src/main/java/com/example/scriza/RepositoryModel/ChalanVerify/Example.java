package com.example.scriza.RepositoryModel.ChalanVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("provider_id")
    @Expose
    private String providerId;
    @SerializedName("data")
    @Expose
    private List<Datum> data;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, Integer status, String number, String providerId, List<Datum> data, String message) {
        this.statusId = statusId;
        this.status = status;
        this.number = number;
        this.providerId = providerId;
        this.data = data;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
