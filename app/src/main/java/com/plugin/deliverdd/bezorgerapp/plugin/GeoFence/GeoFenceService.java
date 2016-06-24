package com.plugin.deliverdd.bezorgerapp.plugin.GeoFence;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationService;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationUser;

import java.util.ArrayList;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class GeoFenceService extends Service implements ILocationUser {

    private ArrayList<GeoFence> _geoFences;

    public GeoFenceService(ILocationService locationService){
        super();
        locationService.addLocationUser(this);
        this._geoFences = new ArrayList<GeoFence>();
    }


    public void addGeoFence(GeoFence geoFence){
        this._geoFences.add(geoFence);
    }

    @Override
    public void onLocation(Location location) {

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
