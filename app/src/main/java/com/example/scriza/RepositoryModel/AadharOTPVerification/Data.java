package com.example.scriza.RepositoryModel.AadharOTPVerification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("ref_id")
    @Expose
    private String refId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("care_of")
    @Expose
    private String careOf;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("split_address")
    @Expose
    private SplitAddress splitAddress;
    @SerializedName("year_of_birth")
    @Expose
    private String yearOfBirth;
    @SerializedName("mobile_hash")
    @Expose
    private String mobileHash;
    @SerializedName("photo_link")
    @Expose
    private String photoLink;

    public Data(String refId, String status, String message, String careOf, String address, String dob, String email, String gender, String name, SplitAddress splitAddress, String yearOfBirth, String mobileHash, String photoLink) {
        this.refId = refId;
        this.status = status;
        this.message = message;
        this.careOf = careOf;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.splitAddress = splitAddress;
        this.yearOfBirth = yearOfBirth;
        this.mobileHash = mobileHash;
        this.photoLink = photoLink;
    }

    public String getRefId() {
        return refId;
    }

    public void setRefId(String refId) {
        this.refId = refId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCareOf() {
        return careOf;
    }

    public void setCareOf(String careOf) {
        this.careOf = careOf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SplitAddress getSplitAddress() {
        return splitAddress;
    }

    public void setSplitAddress(SplitAddress splitAddress) {
        this.splitAddress = splitAddress;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getMobileHash() {
        return mobileHash;
    }

    public void setMobileHash(String mobileHash) {
        this.mobileHash = mobileHash;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
