package com.example.scriza.HomeSection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.scriza.Adapters.HomeAdapter;
import com.example.scriza.Fragments.HomeFragment;
import com.example.scriza.Fragments.NotificationFragment;
import com.example.scriza.Fragments.ProfileFragment;
import com.example.scriza.LoginSection.LoginActivity;
import com.example.scriza.R;
import com.example.scriza.databinding.ActivityDashboardBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class DashboardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ActivityDashboardBinding binding;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        basicMethods();
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(this);
        binding.bottomNavigationView.setSelectedItemId(R.id.dashboard);

    }

    private void basicMethods() {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                break;


            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment).commit();
                break;

            case R.id.logout:
                logoutApp();
                break;
        }
        return true;
    }

    private void logoutApp() {
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Verification App")
                .setContentText("Are you sure you want to exit ?")
                .setCancelText("No")
                .setConfirmText("Yes").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
//                        sDialog.cancel();
                    }
                }).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
