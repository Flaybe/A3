package com.example.a3;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder{
    TextView textView;

    public ItemViewHolder(View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.groupName);
    }
}
