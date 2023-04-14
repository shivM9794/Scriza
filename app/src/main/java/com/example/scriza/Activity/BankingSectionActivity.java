package com.example.scriza.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.scriza.R;
import com.example.scriza.databinding.ActivityBankingSectionBinding;

public class BankingSectionActivity extends AppCompatActivity {
    ActivityBankingSectionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_banking_section);
        basicMethods();
    }

    private void basicMethods() {
    }
}