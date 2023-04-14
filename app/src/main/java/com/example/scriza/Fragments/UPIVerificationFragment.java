package com.example.scriza.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.scriza.R;
import com.example.scriza.RepositoryModel.UPIVerify.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentUPIVerificationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UPIVerificationFragment extends BottomSheetDialogFragment {
    FragmentUPIVerificationBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String upiNumber, token;


    public UPIVerificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_u_p_i_verification, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnUPIVerify.setOnClickListener(view -> verifyUPI());
        return binding.getRoot();
    }

    private void verifyUPI() {
        binding.spinKit.setVisibility(View.VISIBLE);
        upiNumber = binding.txtUpiNo.getText().toString();
        token = sharedPreferences.getString("api_token", "");
        if (upiNumber.isEmpty()) {
            binding.txtUpiNo.setError("Required");
            return;
        }
        Log.e("upiNumber", "number " + upiNumber);
        Log.e("token", "api " + token);
        Call<Example> call = RetrofitClient.getInstance().getApi().upiverification(upiNumber, "388", "111", "Bearer " + token);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getStatusId() == 1) {
                            binding.spinKit.setVisibility(View.GONE);
                            binding.detailsLayout.setVisibility(View.VISIBLE);
                            binding.userName.setText(example.getName());
//                        Toast.makeText(getActivity(),example.getMessage(), Toast.LENGTH_SHORT).show();
                        } else {
                            binding.spinKit.setVisibility(View.GONE);
                            binding.detailsLayout.setVisibility(View.GONE);
//                            Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                } else {
//                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}