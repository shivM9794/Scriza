package com.example.scriza.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scriza.Activity.AadharVerificationActivity;
import com.example.scriza.Fragments.BankAccountVerificationFragment;
import com.example.scriza.Fragments.ChallanFragment;
import com.example.scriza.Fragments.GSTVerificationFragment;
import com.example.scriza.Fragments.PancardVerificationFragment;
import com.example.scriza.Fragments.UPIVerificationFragment;
import com.example.scriza.Models.VerificationModel;
import com.example.scriza.R;

import java.util.ArrayList;

public class VerificationAdapter extends RecyclerView.Adapter<VerificationAdapter.ViewHolder> {

    ArrayList<VerificationModel> verificationModels = new ArrayList<>();
    Context context;

    public VerificationAdapter(ArrayList<VerificationModel> verificationModels, Context context) {
        this.verificationModels = verificationModels;
        this.context = context;
    }

    @NonNull
    @Override
    public VerificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verification, parent, false);
        return new VerificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VerificationAdapter.ViewHolder holder, int position) {
//        VerificationModel verificationModel = verificationModels.get(position);
//        holder.imageView.setImageResource(verificationModel.getImage());
//        holder.tv_name.setText(verificationModel.getName());

        if (position == 0) {
            holder.imageView.setImageResource(R.drawable.pancard);
            holder.tv_name.setText("Pancard Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                PancardVerificationFragment pancardVerificationFragment = new PancardVerificationFragment();
                pancardVerificationFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "PancardVerificationFragment");
            });
        }

        if (position == 1) {
            holder.imageView.setImageResource(R.drawable.banking);
            holder.tv_name.setText("Adharcard Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                Intent intent = new Intent(context, AadharVerificationActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            });
        }

        if (position == 2) {
            holder.imageView.setImageResource(R.drawable.upi_logo);
            holder.tv_name.setText("UPI Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                UPIVerificationFragment upiVerificationFragment = new UPIVerificationFragment();
                upiVerificationFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "UPIVerificationFragment");
            });
        }

        if (position == 3) {
            holder.imageView.setImageResource(R.drawable.bank_account_logo);
            holder.tv_name.setText("Bank Account Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                BankAccountVerificationFragment bankAccountVerificationFragment = new BankAccountVerificationFragment();
                bankAccountVerificationFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "BankAccountVerificationFragment");
            });
        }

        if (position == 4) {
            holder.imageView.setImageResource(R.drawable.gst);
            holder.tv_name.setText("GST Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                GSTVerificationFragment gstVerificationFragment = new GSTVerificationFragment();
                gstVerificationFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "GSTVerificationFragment");
            });
        }

        if (position == 5) {
            holder.imageView.setImageResource(R.drawable.challan);
            holder.tv_name.setText("Chalan Verification");
            holder.clickable_ll.setOnClickListener(view -> {
                ChallanFragment challanFragment = new ChallanFragment();
                challanFragment.show(((FragmentActivity) context).getSupportFragmentManager(), "ChalanVerificationFragment");
            });
        }


    }

    @Override
    public int getItemCount() {
        return verificationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout clickable_ll;
        TextView tv_name;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
            tv_name = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
