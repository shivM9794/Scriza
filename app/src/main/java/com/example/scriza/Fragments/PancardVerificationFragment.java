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
import com.example.scriza.RepositoryModel.PanVerify.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentPancardVerificationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PancardVerificationFragment extends BottomSheetDialogFragment {
    FragmentPancardVerificationBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String panNumber, token;


    public PancardVerificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_pancard_verification, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnPanverify.setOnClickListener(view -> verification());
        return binding.getRoot();
    }

    private void verification() {
        binding.spinKit.setVisibility(View.VISIBLE);
        panNumber = binding.txtPanNo.getText().toString().trim();
        token = sharedPreferences.getString("api_token", "");
        if (panNumber.isEmpty()) {
            binding.txtPanNo.setError("Required");
            return;
        }
        Log.e("pan", "number " + panNumber);
        Log.e("token", "api " + token);
        Call<Example> call = RetrofitClient.getInstance().getApi().panverification(panNumber, "385", "111", "Bearer " + token);
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
                            binding.userFatherName.setText(example.getFatherName());
                            binding.typeUser.setText(example.getType());
//                            Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        binding.spinKit.setVisibility(View.GONE);
                        binding.detailsLayout.setVisibility(View.GONE);


                    }

                } else {
                    binding.spinKit.setVisibility(View.GONE);
                    binding.detailsLayout.setVisibility(View.GONE);


                }

            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}