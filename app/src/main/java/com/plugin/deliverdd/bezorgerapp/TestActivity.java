package com.plugin.deliverdd.bezorgerapp;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.plugin.deliverdd.bezorgerapp.plugin.Location.LocationService;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_activetie);
        startService(new Intent(getBaseContext(), LocationService.class));
    }
}
