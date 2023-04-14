package com.example.scriza.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.scriza.Activity.VerificationActivity;
import com.example.scriza.R;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new HomeAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {

        if (position == 0) {
            holder.image.setImageResource(R.drawable.id_verification);
//            holder.image1.setImageResource(R.drawable.id);
//            holder.back.setBackgroundColor(Color.parseColor("#E6E53935"));
            holder.text.setText("Verification Section");
            holder.clickable_ll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, VerificationActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
        if (position == 1) {
            holder.image.setImageResource(R.drawable.banking);
//            holder.image1.setImageResource(R.drawable.bank);
//            holder.back.setBackgroundColor(Color.parseColor("#F236883A"));
            holder.text.setText("Banking Section");
        }


    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image, image1;
        TextView text;
        LinearLayout clickable_ll;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            clickable_ll = itemView.findViewById(R.id.clickable_ll);
            image = itemView.findViewById(R.id.image);
//            image1 = itemView.findViewById(R.id.image1);
            text = itemView.findViewById(R.id.text);
//            back = itemView.findViewById(R.id.back);

        }
    }
}
