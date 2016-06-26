package com.plugin.deliverdd.bezorgerapp.plugin.Location;

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

import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationService;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationUser;

import java.util.ArrayList;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class LocationService extends Service implements ILocationService {

    private LocationManager _locationManager;

    private LocationListener _locationListener;

    private ArrayList<ILocationUser> _locationListeners;

    public LocationService() {
        this._locationListeners = new ArrayList<ILocationUser> ();
    }

    @Override
    public void onCreate() {
        this._locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        this._locationListeners = new ArrayList<ILocationUser> ();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        this._locationListener = new LocationListener(this);
        initialize();
        return 1;
    }

    private void initialize(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        _locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, _locationListener);
    }

    //Trigger callbacks
    public void onLocation(Location location) {
        for (int i = 0; i<_locationListeners.size();i++){
            _locationListeners.get(i).onLocation(location);
        }
    }
    //Add callback if not exits
    public void addLocationListener(ILocationUser listener){
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
