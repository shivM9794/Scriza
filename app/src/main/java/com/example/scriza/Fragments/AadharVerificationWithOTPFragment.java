package com.example.scriza.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.scriza.HomeSection.DashboardActivity;
import com.example.scriza.R;
import com.example.scriza.RepositoryModel.AadharWithOTP.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentAadharVerificationWithOTPBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AadharVerificationWithOTPFragment extends BottomSheetDialogFragment {
    FragmentAadharVerificationWithOTPBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String e1 = "", e2 = "", e3 = "", e4 = "", e5 = "", e6 = "";
    String aadharNumber, mobileNumber, token;


    public AadharVerificationWithOTPFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_aadhar_verification_with_o_t_p, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnSubmit.setOnClickListener(view -> otpVerify());
        binding.btnVerify.setOnClickListener(view -> showDetails());
        return binding.getRoot();
    }

    private void showDetails() {
        Call<com.example.scriza.RepositoryModel.AadharOTPVerification.Example> call = RetrofitClient.getInstance().getApi().adharOTPVerify("123456", "111", "328878", "Bearer " + token);
        call.enqueue(new Callback<com.example.scriza.RepositoryModel.AadharOTPVerification.Example>() {
            @Override
            public void onResponse(Call<com.example.scriza.RepositoryModel.AadharOTPVerification.Example> call, Response<com.example.scriza.RepositoryModel.AadharOTPVerification.Example> response) {
                com.example.scriza.RepositoryModel.AadharOTPVerification.Example example = response.body();
                if (response.isSuccessful()) {
                    if (response.body().getStatusId() == 1) {
                        binding.cardView.setVisibility(View.VISIBLE);
                        binding.name.setText(example.getData().getName());
                        binding.careOf.setText(example.getData().getCareOf());
                        binding.address.setText(example.getData().getAddress());
                        Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        binding.cardView.setVisibility(View.GONE);
                    }
                } else {
//                    Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<com.example.scriza.RepositoryModel.AadharOTPVerification.Example> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void otpVerify() {
        binding.spinKit.setVisibility(View.VISIBLE);
        aadharNumber = binding.txtAadharNo.getText().toString();
        mobileNumber = binding.txtMobileNo.getText().toString();
        token = sharedPreferences.getString("api_token", "");
        Log.e("aadharNumber", "number " + aadharNumber);
        Log.e("mobileNo", "number" + mobileNumber);
        Log.e("token", "api " + token);
        if (aadharNumber.isEmpty()) {
            binding.txtAadharNo.setError("Required");
            return;
        }
        if (mobileNumber.isEmpty()) {
            binding.txtMobileNo.setError("Required");
            return;
        }

        Call<Example> call = RetrofitClient.getInstance().getApi().aadharwithOTP(aadharNumber, mobileNumber, "10", "111", "Bearer " + token);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatusId() == 1) {
                            addListeners();
                            binding.spinKit.setVisibility(View.GONE);
                            binding.otplayout.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            binding.spinKit.setVisibility(View.GONE);
                            binding.otplayout.setVisibility(View.GONE);
//                            Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                        }

                    } else {
//                        Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
//                    Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void addListeners() {

        binding.etEmail1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e1 = s.toString();
                if (e1.length() == 1)
                    binding.etEmail2.requestFocus();
                checkForBlanks();
            }


            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        binding.etEmail2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e2 = s.toString();
                if (e2.length() == 1)
                    binding.etEmail3.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        binding.etEmail3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e3 = s.toString();
                if (e3.length() == 1)
                    binding.etEmail4.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        binding.etEmail4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e4 = s.toString();
                checkForBlanks();
                if (e4.length() == 1)
                    binding.etEmail5.requestFocus();
                hideKeyboardFrom(getActivity(), binding.etEmail4);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        binding.etEmail5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e5 = s.toString();
                checkForBlanks();
                if (e5.length() == 1) {
                    binding.etEmail6.requestFocus();
                    hideKeyboardFrom(getActivity(), binding.etEmail5);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        binding.etEmail6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e6 = s.toString();
                checkForBlanks();
                if (e6.length() == 1) {
                    hideKeyboardFrom(getActivity(), binding.etEmail5);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void checkForBlanks() {
        if (e1.equals("") || e2.equals("") || e3.equals("") || e4.equals("") || e5.equals("") || e6.equals("")) {
            binding.btnVerify.setVisibility(View.GONE);
        } else {

            binding.btnVerify.setVisibility(View.VISIBLE);
        }

    }

//    public void verify_otp(View view) {
//
//        String e = e1 + e2 + e3 + e4 + e5 + e6 ;
//        Log.e("Email Otp", e);
//        Intent intent = new Intent(getActivity(), DashboardActivity.class);
//        startActivity(intent);
//
//    }


}