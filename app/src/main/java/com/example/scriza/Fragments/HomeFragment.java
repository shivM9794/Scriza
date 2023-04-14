package com.example.scriza.Fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scriza.Adapters.HomeAdapter;
import com.example.scriza.R;
import com.example.scriza.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    HomeAdapter homeAdapter;


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeOptions();
        return binding.getRoot();
    }

    private void homeOptions() {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        homeAdapter = new HomeAdapter(getActivity());
        binding.recyclerView.setAdapter(homeAdapter);

    }
}


