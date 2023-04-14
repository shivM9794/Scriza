package com.example.scriza.RepositoryModel.AadharWithoutOTP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("ageBand")
    @Expose
    private String ageBand;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("aadhaar_number")
    @Expose
    private String aadhaarNumber;
    @SerializedName("report_id")
    @Expose
    private Integer reportId;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, String state, String ageBand, String gender, String mobileNumber, String aadhaarNumber, Integer reportId, String message) {
        this.statusId = statusId;
        this.state = state;
        this.ageBand = ageBand;
        this.gender = gender;
        this.mobileNumber = mobileNumber;
        this.aadhaarNumber = aadhaarNumber;
        this.reportId = reportId;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAgeBand() {
        return ageBand;
    }

    public void setAgeBand(String ageBand) {
        this.ageBand = ageBand;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
