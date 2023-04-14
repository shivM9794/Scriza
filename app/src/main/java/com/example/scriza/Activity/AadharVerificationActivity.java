package com.example.scriza.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.scriza.Fragments.AadharVerificationFragment;
import com.example.scriza.Fragments.AadharVerificationWithOTPFragment;
import com.example.scriza.R;
import com.example.scriza.databinding.ActivityAadharVerificationBinding;

public class AadharVerificationActivity extends AppCompatActivity {
    ActivityAadharVerificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aadhar_verification);
        basicMethods();
    }

    private void basicMethods() {
        binding.radioWithoutMobile.setOnClickListener(view -> {
            AadharVerificationFragment aadharVerificationFragment = new AadharVerificationFragment();
            aadharVerificationFragment.show(getSupportFragmentManager(), "AadharVerificationFragment");
        });
        binding.radioMobileVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AadharVerificationWithOTPFragment aadharVerificationWithOTPFragment = new AadharVerificationWithOTPFragment();
                aadharVerificationWithOTPFragment.show(getSupportFragmentManager(),"AadharVerificationWithOTPFragment");
            }
        });
    }
}