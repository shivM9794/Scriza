package com.example.scriza.RepositoryModel.PanVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("father_name")
    @Expose
    private String fatherName;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, String name, String fatherName, String type, String message) {
        this.statusId = statusId;
        this.name = name;
        this.fatherName = fatherName;
        this.type = type;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}