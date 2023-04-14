package com.example.scriza.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.scriza.R;
import com.example.scriza.RepositoryModel.BankAccountVerify.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentBankAccountVerificationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BankAccountVerificationFragment extends BottomSheetDialogFragment {
    FragmentBankAccountVerificationBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String mobileNumber, accountNumber, ifscCode, token;


    public BankAccountVerificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bank_account_verification, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnBankAccountverify.setOnClickListener(view -> verifyBankAccount());
        return binding.getRoot();
    }

    private void verifyBankAccount() {
        binding.spinKit.setVisibility(View.VISIBLE);
        mobileNumber = binding.txtMobileNo.getText().toString();
        accountNumber = binding.txtAccountNo.getText().toString();
        ifscCode = binding.txtIFSCNo.getText().toString();
        if (mobileNumber.isEmpty()) {
            binding.txtMobileNo.setError("Required");
            return;
        }
        if (accountNumber.isEmpty()) {
            binding.txtAccountNo.setError("Required");
            return;
        }
        if (ifscCode.isEmpty()) {
            binding.txtIFSCNo.setError("Required");
            return;
        }
        token = sharedPreferences.getString("api_token", "");
        Call<Example> call = RetrofitClient.getInstance().getApi().bankAccountVerification(mobileNumber, accountNumber, ifscCode, "127", "111", "Bearer " + token);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatusId() == 1) {
                            binding.detailsLayout.setVisibility(View.VISIBLE);
                            binding.userName.setText(example.getName());
                            binding.spinKit.setVisibility(View.GONE);
//                            Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            binding.spinKit.setVisibility(View.GONE);
                            binding.detailsLayout.setVisibility(View.GONE);
                        }

                    }


                } else {
                    binding.spinKit.setVisibility(View.GONE);
                    binding.detailsLayout.setVisibility(View.GONE);
//                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                binding.detailsLayout.setVisibility(View.GONE);
                binding.spinKit.setVisibility(View.GONE);


            }
        });
    }
}