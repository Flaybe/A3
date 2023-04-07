package com.example.a3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;


public class GroupFragment extends Fragment {

    public GroupFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            this.getGroups(recyclerView);
        }
        return view;
    }

    private void getGroups(RecyclerView recyclerView){
        String url = "https://tddd80-server-rmk.azurewebsites.net/grupper";
        RequestQueue queue = Volley.newRequestQueue(requireContext());
        Gson gson = new Gson();
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    System.out.println("response " + response);
                  Groups group = gson.fromJson(response, Groups.class);
                    System.out.println("group " + group.getGrupper());
                  recyclerView.setAdapter(new ItemAdapter(group.getGrupper()));

                }, error -> {
            throw new RuntimeException("That didn't work!");
        });
        queue.add(stringRequest);
    }
}