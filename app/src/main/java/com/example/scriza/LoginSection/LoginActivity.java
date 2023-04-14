package com.example.scriza.LoginSection;

import static com.example.scriza.Utility.PreferenceUtility.token;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.scriza.HomeSection.DashboardActivity;
import com.example.scriza.R;
import com.example.scriza.RepositoryModel.Login.Example;
import com.example.scriza.RepositoryModel.Login.User;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.Utility.PreferenceUtility;
import com.example.scriza.ViewModel.DataViewModel;
import com.example.scriza.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    private static final int PERMISSION_READ_STATE = 1;
    boolean isAllFieldsChecked = false;
    DataViewModel dataViewModel;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String user_email, user_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        sharedPreferences = getSharedPreferences("Scriza", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        basicMethods();

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            requestPermission();
        }

    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE, Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION}, PERMISSION_READ_STATE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_READ_STATE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[3] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[4] == PackageManager.PERMISSION_GRANTED) {

                } else {


                }
            }
            break;
        }
    }


    private void basicMethods() {
        binding.txtSignup.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
        binding.txtLoginBtn.setOnClickListener(view -> {
            login_successful();
        });
    }

    private Boolean emailValidation() {

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (user_email.isEmpty()) {
            binding.usernameInput.setError("Field cannot be empty");
            return false;
        } else if (!user_email.matches(emailPattern)) {
            binding.usernameInput.setError("Invalid Email Address");
            return false;
        } else {
            binding.usernameInput.setError(null);
            return true;
        }
    }

    private Boolean passwordValidation() {
        String passwordVal = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
//                ".{4,}" +               //at least 4 characters
                "$";

        if (user_password.isEmpty()) {
            binding.pass.setError("Required");
            return false;
        }
//        else if (!user_password.matches(passwordVal)) {
//            binding.pass.setError("Password is weak");
//            return false;
//        }
        else {
            binding.pass.setError(null);
            return true;
        }
    }


    private void login_successful() {
        binding.spinKit.setVisibility(View.VISIBLE);
        user_email = binding.usernameInput.getText().toString();
        user_password = binding.pass.getText().toString();
        emailValidation();
        passwordValidation();


        Call<Example> call = RetrofitClient.getInstance().getApi().login(user_email, user_password);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example user = response.body();
                if (response.isSuccessful()) {
                    editor.putString("api_token", response.body().getToken());
                    editor.putBoolean("isLogging", true);

                    binding.spinKit.setVisibility(View.GONE);
                    Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                    startActivity(intent);
                    editor.commit();


                } else {

                    binding.spinKit.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}

