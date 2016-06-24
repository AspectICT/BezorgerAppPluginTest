package com.plugin.deliverdd.bezorgerapp.plugin;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class GeofenceService extends Service implements ILocationUser {

    public GeofenceService(LocationService locationService){
        super();
        locationService.addLocationUser(this);
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
