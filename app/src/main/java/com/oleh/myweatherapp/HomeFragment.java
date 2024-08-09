package com.oleh.myweatherapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    public Button button1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        button1 = (android.widget.Button) view.findViewById(R.id.button1);
        button1.setOnClickListener(infl -> {
            Intent intent = new Intent(view.getContext(), PagerActivity.class);

            startActivity(intent);
        });
        return view;
    }


}

