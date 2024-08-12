package com.oleh.myweatherapp;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.oleh.myweatherapp.storage.Location;
import com.oleh.myweatherapp.storage.LocationDAO;
import com.oleh.myweatherapp.storage.LocationStorage;

import java.util.List;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pager);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        LocationDAO locationDAO = new LocationStorage(this);
        List<Location> locationList = locationDAO.getAllLocations();

        WeatherPageAdapter adapter = new WeatherPageAdapter(locationList);
//        WeatherPageAdapterFragment second = new WeatherPageAdapterFragment(locationList);

        ViewPager2 weatherPager = findViewById(R.id.weatherPager);
        weatherPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        weatherPager.setAdapter(adapter);
//        weatherPager.setAdapter(second);
//        if (savedInstanceState == null) {

//            getSupportFragmentManager().beginTransaction().replace(R.id.weatherPager, new WeatherPageAdapterFragment(locationList)).commit();
//            navigationView.setCheckedItem(R.id.nav_home);

//        }
    }
}