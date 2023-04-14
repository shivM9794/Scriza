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
import com.example.scriza.RepositoryModel.GSTVerify.Example;
import com.example.scriza.Retrofit.RetrofitClient;
import com.example.scriza.databinding.FragmentGSTVerificationBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class GSTVerificationFragment extends BottomSheetDialogFragment {
    FragmentGSTVerificationBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String gstNumber, token;


    public GSTVerificationFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_g_s_t_verification, container, false);
        sharedPreferences = this.getActivity().getSharedPreferences("Scriza", MODE_PRIVATE);
        binding.btnGSTverify.setOnClickListener(view -> verifyGST());
        return binding.getRoot();
    }

    private void verifyGST() {
        binding.spinKit.setVisibility(View.VISIBLE);
        gstNumber = binding.txtGSTNo.getText().toString();
        token = sharedPreferences.getString("api_token", "");
        if (gstNumber.isEmpty()) {
            binding.txtGSTNo.setError("Required");
            return;
        }
        Log.e("gstNumber", "number " + gstNumber);
        Log.e("token", "api " + token);
        Call<Example> call = RetrofitClient.getInstance().getApi().gstverification(gstNumber, "389", "111", "Bearer " + token);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example example = response.body();
                if (response.isSuccessful()) {
                    if (response.body().getStatusId() == 1) {
                        binding.spinKit.setVisibility(View.GONE);
                        binding.detailsLayout.setVisibility(View.VISIBLE);
                        binding.userName.setText(example.getLegalNameOfBusiness());
                        binding.registrationDate.setText(example.getDateOfRegistration());
                        binding.gstStatus.setText(example.getGstInStatus());
                        binding.address.setText(example.getPrincipalPlaceAddress());
                        binding.constitutionofBusiness.setText(example.getConstitutionOfBusiness());
//                        Toast.makeText(getActivity(), example.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        binding.spinKit.setVisibility(View.GONE);
                        binding.detailsLayout.setVisibility(View.GONE);
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