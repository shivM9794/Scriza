package com.example.scriza.Fragments;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.scriza.Adapters.NotificationAdapter;
import com.example.scriza.Models.NotificationModel;
import com.example.scriza.R;
import com.example.scriza.databinding.FragmentNotificationBinding;

import java.util.ArrayList;


public class NotificationFragment extends Fragment {
    FragmentNotificationBinding binding;
    NotificationAdapter notificationAdapter;


    public NotificationFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_notification, container, false);
        notificationList();
        return binding.getRoot();
    }

    private void notificationList() {
        binding.recyclerNotification.setHasFixedSize(true);
        binding.recyclerNotification.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ArrayList<NotificationModel> notificationModels = new ArrayList<>();
        notificationModels.add(new NotificationModel("Pancard Verification Done","2021-03-27 05:00:00"));
        notificationModels.add(new NotificationModel("Pancard Verification Done","2021-03-27 05:00:00"));
        notificationModels.add(new NotificationModel("Pancard Verification Done","2021-03-27 05:00:00"));
        notificationModels.add(new NotificationModel("Pancard Verification Done","2021-03-27 05:00:00"));
        notificationModels.add(new NotificationModel("Pancard Verification Done","2021-03-27 05:00:00"));
        notificationAdapter = new NotificationAdapter(notificationModels, getContext());
        binding.recyclerNotification.setAdapter(notificationAdapter);
    }
}