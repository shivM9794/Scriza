package com.example.scriza.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.scriza.Adapters.VerificationAdapter;
import com.example.scriza.HomeSection.DashboardActivity;
import com.example.scriza.Models.VerificationModel;
import com.example.scriza.R;
import com.example.scriza.databinding.ActivityVerificationBinding;

import java.util.ArrayList;

public class VerificationActivity extends AppCompatActivity {
    ActivityVerificationBinding binding;
    VerificationAdapter verificationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_verification);
        basicMethods();
        verificationList();
    }

    private void verificationList() {
        binding.recyclerVerification.setHasFixedSize(true);
        binding.recyclerVerification.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<VerificationModel> verificationModels = new ArrayList<>();
        verificationModels.add(new VerificationModel("Pancard Verification",R.drawable.pancard));
        verificationModels.add(new VerificationModel("Aadhar Card Verification",R.drawable.aadhar));
        verificationModels.add(new VerificationModel("UPI Verification",R.drawable.upi_logo));
        verificationModels.add(new VerificationModel("Bank Account Verification",R.drawable.bank_account_logo));
        verificationModels.add(new VerificationModel("GST Verification",R.drawable.gst));
        verificationModels.add(new VerificationModel("Challan",R.drawable.challan));
        verificationAdapter = new VerificationAdapter(verificationModels,this);
        binding.recyclerVerification.setAdapter(verificationAdapter);
    }

    private void basicMethods() {
        binding.backArrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
        });
    }
}