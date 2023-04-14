package com.example.scriza.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scriza.Models.NotificationModel;
import com.example.scriza.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    ArrayList<NotificationModel> notificationModels = new ArrayList<>();
    Context context;

    public NotificationAdapter(ArrayList<NotificationModel> notificationModels, Context context) {
        this.notificationModels = notificationModels;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification, parent, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.ViewHolder holder, int position) {
        NotificationModel notificationModel = notificationModels.get(position);
        holder.notificationHeading.setText(notificationModel.getHeading());
        holder.date.setText(notificationModel.getDatetime());

    }

    @Override
    public int getItemCount() {
        return notificationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView notificationHeading, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            notificationHeading = itemView.findViewById(R.id.notificationHeading);
            date = itemView.findViewById(R.id.date);
        }
    }
}
