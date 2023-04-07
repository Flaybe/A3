package com.example.a3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private final ArrayList<String> groupList;

    public ItemAdapter(ArrayList<String> groupList) {
        this.groupList = groupList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TextView textView = holder.textView;
        holder.textView.setText(groupList.get(position));

        textView.setOnClickListener(v -> {
            GroupFragmentDirections.ActionGroupFragmentToDetailFragment action =
                    GroupFragmentDirections.actionGroupFragmentToDetailFragment(groupList.get(position));
            NavController navController = Navigation.findNavController(v);
            navController.navigate(action);

        });
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

}
