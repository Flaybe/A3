package com.example.a3;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a3.databinding.FragmentDetailBinding;
import com.google.gson.Gson;


public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        binding.details.setText("This is the details fragment");
        DetailFragmentArgs args = DetailFragmentArgs.fromBundle(getArguments());
        String GroupName = args.getGroupName();
        doVolleyStuff(GroupName);

        return binding.getRoot();
    }

    private void doVolleyStuff(String GroupName) {
        String url = "https://tddd80-server-rmk.azurewebsites.net/medlemmar/"+ GroupName;
        RequestQueue queue = Volley.newRequestQueue(requireContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {
                    Gson gson = new Gson();
                    Members members = gson.fromJson(response, Members.class);
                    StringBuilder sb = new StringBuilder();
                    for (Members.Member member : members.getMedlemmar()){
                         sb.append("Name: " + member.getNamn() + "\nEmail: " + member.getEpost() + "\nAnswered: " +
                                member.getSvarade() + "\n\n" );
                    }
                    binding.details.setText(sb.toString());

                }, error -> {
            binding.details.setText("That didn't work!");
        });
        queue.add(stringRequest);
    }
}