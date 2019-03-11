package com.nmealibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.GpsStatus.NmeaListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class RNNmeaLibraryModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private final LocationManager locationManager;

    private final NmeaListener listener;

    public RNNmeaLibraryModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        this.locationManager = (LocationManager) reactContext.getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
        this.listener = new NmeaMessageListener(this.reactContext);
    }

    @Override
    public String getName() {
        return "RNNmeaLibrary";
    }

    @ReactMethod
    public void start() {
        LocationListener locationListener = new NmeaLocationListener();
        this.locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, locationListener);

        this.locationManager.addNmeaListener(this.listener);
    }

    @ReactMethod
    public void stop() {
        this.locationManager.removeNmeaListener(this.listener);
    }
}