package com.example.scriza.RepositoryModel.AadharOTPVerification;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SplitAddress {

    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("dist")
    @Expose
    private String dist;
    @SerializedName("house")
    @Expose
    private String house;
    @SerializedName("landmark")
    @Expose
    private String landmark;
    @SerializedName("pincode")
    @Expose
    private String pincode;
    @SerializedName("po")
    @Expose
    private String po;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("subdist")
    @Expose
    private String subdist;
    @SerializedName("vtc")
    @Expose
    private String vtc;

    public SplitAddress(String country, String dist, String house, String landmark, String pincode, String po, String state, String street, String subdist, String vtc) {
        this.country = country;
        this.dist = dist;
        this.house = house;
        this.landmark = landmark;
        this.pincode = pincode;
        this.po = po;
        this.state = state;
        this.street = street;
        this.subdist = subdist;
        this.vtc = vtc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSubdist() {
        return subdist;
    }

    public void setSubdist(String subdist) {
        this.subdist = subdist;
    }

    public String getVtc() {
        return vtc;
    }

    public void setVtc(String vtc) {
        this.vtc = vtc;
    }
}
