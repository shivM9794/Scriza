package com.example.scriza.RepositoryModel.AadharWithOTP;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("report_id")
    @Expose
    private Long reportId;
    @SerializedName("reference_id")
    @Expose
    private String referenceId;
    @SerializedName("api_id")
    @Expose
    private Integer apiId;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, Long reportId, String referenceId, Integer apiId, String message) {
        this.statusId = statusId;
        this.reportId = reportId;
        this.referenceId = referenceId;
        this.apiId = apiId;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
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
