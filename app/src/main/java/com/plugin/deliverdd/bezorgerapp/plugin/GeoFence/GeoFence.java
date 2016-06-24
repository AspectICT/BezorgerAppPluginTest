package com.plugin.deliverdd.bezorgerapp.plugin.GeoFence;

import android.location.Location;

/**
 * Created by Gerjan on 24-6-2016.
 */
public class GeoFence {

    public int identifier;
    public Location location;
    public int radius;

    public boolean inRadius(Location location){
        return this.location.distanceTo(location)<radius;
    }
}
