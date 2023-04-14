package com.example.scriza.Fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.scriza.R;
import com.example.scriza.RepositoryModel.AadharWithoutOTP.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentAadharVerificationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AadharVerificationFragment extends BottomSheetDialogFragment {

    FragmentAadharVerificationBinding binding;
    String aadharNumber, token;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    public AadharVerificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_aadhar_verification, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnAadharverify.setOnClickListener(view -> verifyAadharWithoutOTP());
        return binding.getRoot();
    }

    private void verifyAadharWithoutOTP() {
        aadharNumber = binding.txtAadharNo.getText().toString();
        token = sharedPreferences.getString("api_token", "");
        Log.e("aadharNumber", "number " + aadharNumber);
        Log.e("token", "api " + token);
        Call<Example> call = RetrofitClient.getInstance().getApi().aadharwitoutOpt(aadharNumber, "388", "111", "Bearer " + token);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful()) {
                    Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
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