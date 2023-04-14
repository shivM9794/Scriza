package com.example.scriza.RepositoryModel.GSTVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {
    @SerializedName("status_id")
    @Expose
    private Integer statusId;
    @SerializedName("legal_name_of_business")
    @Expose
    private String legalNameOfBusiness;
    @SerializedName("center_jurisdiction")
    @Expose
    private String centerJurisdiction;
    @SerializedName("state_jurisdiction")
    @Expose
    private String stateJurisdiction;
    @SerializedName("date_of_registration")
    @Expose
    private String dateOfRegistration;
    @SerializedName("constitution_of_business")
    @Expose
    private String constitutionOfBusiness;
    @SerializedName("taxpayer_type")
    @Expose
    private String taxpayerType;
    @SerializedName("gst_in_status")
    @Expose
    private String gstInStatus;
    @SerializedName("last_update_date")
    @Expose
    private String lastUpdateDate;
    @SerializedName("nature_of_business_activities")
    @Expose
    private List<String> natureOfBusinessActivities;
    @SerializedName("principal_place_address")
    @Expose
    private String principalPlaceAddress;
    @SerializedName("report_id")
    @Expose
    private Integer reportId;
    @SerializedName("message")
    @Expose
    private String message;

    public Example(Integer statusId, String legalNameOfBusiness, String centerJurisdiction, String stateJurisdiction, String dateOfRegistration, String constitutionOfBusiness, String taxpayerType, String gstInStatus, String lastUpdateDate, List<String> natureOfBusinessActivities, String principalPlaceAddress, Integer reportId, String message) {
        this.statusId = statusId;
        this.legalNameOfBusiness = legalNameOfBusiness;
        this.centerJurisdiction = centerJurisdiction;
        this.stateJurisdiction = stateJurisdiction;
        this.dateOfRegistration = dateOfRegistration;
        this.constitutionOfBusiness = constitutionOfBusiness;
        this.taxpayerType = taxpayerType;
        this.gstInStatus = gstInStatus;
        this.lastUpdateDate = lastUpdateDate;
        this.natureOfBusinessActivities = natureOfBusinessActivities;
        this.principalPlaceAddress = principalPlaceAddress;
        this.reportId = reportId;
        this.message = message;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getLegalNameOfBusiness() {
        return legalNameOfBusiness;
    }

    public void setLegalNameOfBusiness(String legalNameOfBusiness) {
        this.legalNameOfBusiness = legalNameOfBusiness;
    }

    public String getCenterJurisdiction() {
        return centerJurisdiction;
    }

    public void setCenterJurisdiction(String centerJurisdiction) {
        this.centerJurisdiction = centerJurisdiction;
    }

    public String getStateJurisdiction() {
        return stateJurisdiction;
    }

    public void setStateJurisdiction(String stateJurisdiction) {
        this.stateJurisdiction = stateJurisdiction;
    }

    public String getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(String dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getConstitutionOfBusiness() {
        return constitutionOfBusiness;
    }

    public void setConstitutionOfBusiness(String constitutionOfBusiness) {
        this.constitutionOfBusiness = constitutionOfBusiness;
    }

    public String getTaxpayerType() {
        return taxpayerType;
    }

    public void setTaxpayerType(String taxpayerType) {
        this.taxpayerType = taxpayerType;
    }

    public String getGstInStatus() {
        return gstInStatus;
    }

    public void setGstInStatus(String gstInStatus) {
        this.gstInStatus = gstInStatus;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<String> getNatureOfBusinessActivities() {
        return natureOfBusinessActivities;
    }

    public void setNatureOfBusinessActivities(List<String> natureOfBusinessActivities) {
        this.natureOfBusinessActivities = natureOfBusinessActivities;
    }

    public String getPrincipalPlaceAddress() {
        return principalPlaceAddress;
    }

    public void setPrincipalPlaceAddress(String principalPlaceAddress) {
        this.principalPlaceAddress = principalPlaceAddress;
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
