package com.example.scriza.LoginSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.scriza.R;
import com.example.scriza.RepositoryModel.Example;
import com.example.scriza.RepositoryModel.User;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.ViewModel.DataViewModel;
import com.example.scriza.databinding.ActivityRegisterBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    DataViewModel dataViewModel;
    String full_name, mobile, email_address, password, confirm_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        dataViewModel = ViewModelProviders.of(this).get(DataViewModel.class);
        basicMethods();
    }

    private void basicMethods() {
        binding.txtLoginBtn.setOnClickListener(view ->
                signUp_verification()
        );

    }

    private Boolean usernameVaildation() {
        if (full_name.isEmpty()) {
            binding.txtfullName.setError("Required");
            return false;
        } else {
            binding.txtfullName.setError(null);
            return true;

        }
    }

    private Boolean emailValidation() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (email_address.isEmpty()) {
            binding.txtEmail.setError("Field cannot be empty");
            return false;
        } else if (!email_address.matches(emailPattern)) {
            binding.txtEmail.setError("Invalid Email Address");
            return false;
        } else {
            binding.txtEmail.setError(null);
            return true;
        }
    }

    private Boolean mobileNoValidation() {
        if (mobile.isEmpty()) {
            binding.txtMobile.setError("Required");
            return false;

        } else {
            binding.txtMobile.setError(null);
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

        if (password.isEmpty()) {
            binding.txtPassword.setError("Required");
            return false;
        } else if (!password.equals(confirm_password)) {
            binding.txtCnfPassword.setError("Password Not Matching");
            return false;
        }
//        else if (!password.matches(passwordVal)) {
//            binding.txtPassword.setError("Password is too weak");
//            return false;
//        }
        else {
            binding.txtPassword.setError(null);
            return true;
        }
    }

    private void signUp_verification() {
//        binding.spinKit.setVisibility(View.VISIBLE);
        full_name = binding.txtfullName.getText().toString();
        mobile = binding.txtMobile.getText().toString();
        email_address = binding.txtEmail.getText().toString();
        password = binding.txtPassword.getText().toString();
        confirm_password = binding.txtCnfPassword.getText().toString();

        emailValidation();
        usernameVaildation();
        mobileNoValidation();
        passwordValidation();

        Call<User> call = RetrofitClient.getInstance().getApi().signUp(full_name, email_address, mobile, password, confirm_password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user = response.body();
                if (response.isSuccessful()) {
//                    binding.spinKit.setVisibility(View.GONE);
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                    return;
//                    Toast.makeText(RegisterActivity.this,user.getActive(),Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(RegisterActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }


}

