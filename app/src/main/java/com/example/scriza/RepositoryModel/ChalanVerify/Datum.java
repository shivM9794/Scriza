package com.example.scriza.RepositoryModel.ChalanVerify;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("bill_number")
    @Expose
    private String billNumber;
    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("bill_net_amount")
    @Expose
    private String billNetAmount;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("duedate")
    @Expose
    private String duedate;
    @SerializedName("billId")
    @Expose
    private String billId;
    @SerializedName("reference_id")
    @Expose
    private String referenceId;

    public Datum(String billNumber, String amount, String billNetAmount, String name, String duedate, String billId, String referenceId) {
        this.billNumber = billNumber;
        this.amount = amount;
        this.billNetAmount = billNetAmount;
        this.name = name;
        this.duedate = duedate;
        this.billId = billId;
        this.referenceId = referenceId;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBillNetAmount() {
        return billNetAmount;
    }

    public void setBillNetAmount(String billNetAmount) {
        this.billNetAmount = billNetAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
