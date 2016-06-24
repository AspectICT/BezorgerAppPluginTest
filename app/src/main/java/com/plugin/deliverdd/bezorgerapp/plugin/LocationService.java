package com.plugin.deliverdd.bezorgerapp.plugin;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class LocationService extends Service  {

    private LocationManager _locationManager;

    private LocationListener _locationListener;

    private ArrayList<ILocationUser> _locationListeners;

    public LocationService() {
        this._locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        this._locationListener = new LocationListener(this);
        this._locationListeners = new ArrayList<ILocationUser> ();
        this.initialize();
    }

    private void initialize(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        _locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 10, _locationListener);
    }

    private void onLocation(Location location) {
        for (int i = 0; i<_locationListeners.size();i++){
            _locationListeners.get(i).onLocation(location);
        }
    }
    public void addLocationUser(ILocationUser listener){
       if(!_locationListeners.contains(listener)){
           _locationListeners.add(listener);
       }
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}