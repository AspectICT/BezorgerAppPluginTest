package com.plugin.deliverdd.bezorgerapp.plugin.GeoFence;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.plugin.deliverdd.bezorgerapp.plugin.GeoFence.Interfaces.IGeoFenceUser;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationService;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationUser;

import java.util.ArrayList;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class GeoFenceService implements ILocationUser {

    private ArrayList<GeoFence> _geoFences;

    private ArrayList<IGeoFenceUser> _geoFenceListeners;

    public GeoFenceService(ILocationService locationService){
        super();
        locationService.addLocationListener(this);
        this._geoFences = new ArrayList<GeoFence>();
        this._geoFenceListeners = new ArrayList<IGeoFenceUser>();
    }

    public void addGeoFence(GeoFence geoFence){
        this._geoFences.add(geoFence);
    }

    public void removeGeoFence(GeoFence geoFence){
        this._geoFences.remove(geoFence);
    }

    public void addGeoFenceListener(IGeoFenceUser listener){
        if(!_geoFenceListeners.contains(listener)){
            _geoFenceListeners.add(listener);
        }
    }

    public void onLocation(Location location) {
        for (int i = 0; i<_geoFences.size();i++){
            if(_geoFences.get(i).inRadius(location)){
                for (int l = 0; l<_geoFenceListeners.size();l++){
                    _geoFenceListeners.get(l).onGeoFence(_geoFences.get(i));
                }
            }
        }
    }
    
}
