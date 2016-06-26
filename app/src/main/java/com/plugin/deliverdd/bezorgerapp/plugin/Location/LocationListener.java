package com.plugin.deliverdd.bezorgerapp.plugin.Location;

import android.location.Location;
import android.os.Bundle;
import java.sql.*;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class LocationListener implements android.location.LocationListener {

    private LocationService _locationService;
    public  LocationListener(LocationService locationService){
        super();
        this._locationService = locationService;

        // start sqllite database
    }

    @Override
    public void onLocationChanged(Location location) {
        _locationService.onLocation(location);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
