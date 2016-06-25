package com.plugin.deliverdd.bezorgerapp.plugin;

import android.os.Bundle;

import com.plugin.deliverdd.bezorgerapp.plugin.GeoFence.GeoFenceService;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.Interfaces.ILocationService;
import com.plugin.deliverdd.bezorgerapp.plugin.Location.LocationService;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.CallbackContext;

import org.apache.cordova.api.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by Jan-WillemW on 6/24/2016.
 * deze class bevat alle interfaces die cordova aanroept
 */
public class DeliverddPlugin extends CordovaPlugin
{
    private ILocationService _locationService;
    private GeoFenceService _geoFenceService;

    private Date _startTime;
    private Date _endTime;
    private int _currentStartMessage;

    // on init create a locationlistener and the geofence service
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        // your init code here

        _locationService = new LocationService();
        _geoFenceService = new GeoFenceService(_locationService);
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException
    {
        if ("onLocation".equals(action)) {
            callbackContext.success();
            return true;
        }
        return false;  // Returning false results in a "MethodNotFound" error.
    }

    // als de plugin naar de achtergrond verhuist
    // moet de localization db gesaved + huidige appsessie
    public Bundle onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putInt("StartMessage", _currentStartMessage);

        if(_startTime != null){
            bundle.putLong("StartTime", _startTime.getTime());
        }
        if(_endTime != null) {
            bundle.putLong("EndTime", _endTime.getTime());
        }

        return bundle;
    }
}

