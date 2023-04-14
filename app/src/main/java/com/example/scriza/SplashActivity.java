package com.example.scriza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;
import com.example.scriza.HomeSection.DashboardActivity;
import com.example.scriza.LoginSection.LoginActivity;
import com.example.scriza.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;
    Handler handler;
    LottieAnimationView lottie;
    Boolean isLogging;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        sharedPreferences = getSharedPreferences("Scriza", MODE_PRIVATE);
        isLogging=sharedPreferences.getBoolean("isLogging",false);
        lottie = findViewById(R.id.lottie);
        handler = new Handler();
        handler.postDelayed(() -> {
            if(isLogging){
                Intent intent=new Intent(SplashActivity.this, DashboardActivity.class);
                startActivity(intent);
            }else {
                Intent intent=new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
            }

        }, 3000);
    }
}


