package com.oleh.myweatherapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


import androidx.annotation.Nullable;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.oleh.myweatherapp.storage.Location;

import java.util.List;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    private final List<Location> locations;
    public TextView tempFeelsLikeTextVie;
    public TextView minTempTextView;
    public TextView maxTempTextView;
    public TextView weatherDescriptionTextView;



    public BottomSheetDialog(List<Location> locations) {
        this.locations = locations;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottomsheetlayout,
                container, false);

        tempFeelsLikeTextVie = container.findViewById(R.id.tempFeelsLikeTextView);
        minTempTextView = container.findViewById(R.id.minTempTextView);
        maxTempTextView = container.findViewById(R.id.maxTempTextView);
        weatherDescriptionTextView = container.findViewById(R.id.weatherDescriptionTextView);
        return v;
    }
}

