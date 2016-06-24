package com.plugin.deliverdd.bezorgerapp;

import android.content.Context;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activetie);
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
    }
}
