package com.oleh.myweatherapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;

public class HomeFragment extends Fragment {
    public Button button1;
    private LottieAnimationView wsIcon;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        MediaPlayer mediaPlayer = MediaPlayer.create(getContext().getApplicationContext(), R.raw.weather_service);
        mediaPlayer.start();
        button1 = view.findViewById(R.id.button1);
        wsIcon = view.findViewById(R.id.wsIcon);
        button1.setOnClickListener(infl -> {
            Intent intent = new Intent(view.getContext(), PagerActivity.class);

            startActivity(intent);
        });

        wsIcon.setAnimation(R.raw.thunderstorm);
        return view;
    }


}

