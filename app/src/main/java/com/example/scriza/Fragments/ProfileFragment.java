package com.example.scriza.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scriza.R;
import com.example.scriza.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    FragmentProfileBinding binding;


    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);
        binding.txtPrivacy.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new PrivacyPolicyFragment());
            fragmentTransaction.commit();
        });
        binding.txtTandC.setOnClickListener(view -> {
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, new TermsAndConditionFragment());
            fragmentTransaction.commit();
        });
        return binding.getRoot();
    }
}