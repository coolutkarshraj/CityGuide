package com.io.utkarsh.cityguide.Services;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;

import java.util.List;

public class LocitionUpdater extends Service{
    private FusedLocationProviderClient client;
    private LocationRequest locationRequest;


    @Override
    public void onCreate() {
        super.onCreate();
        client = LocationServices.getFusedLocationProviderClient(this);
        locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(0);
        locationRequest.setFastestInterval(0);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            client.requestLocationUpdates(locationRequest, locationCallback, null);
        } catch (SecurityException ignore) {
            Log.e("AppLocationService", "SecurityException - " + ignore.toString(), ignore);
        }
        return START_STICKY;
    }

    private final LocationCallback locationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locationList = locationResult.getLocations();
            if (locationList.size() != 0) {
                Location location = locationList.get(0);
                Log.e("AppLocationService", "Latitude  - " +location.getLatitude()+", longitude  - " +location.getLongitude() );
            }
        }
    };


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
