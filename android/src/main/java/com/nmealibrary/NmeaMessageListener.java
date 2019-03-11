package com.nmealibrary;

import android.location.GpsStatus.NmeaListener;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import javax.annotation.Nullable;

public class NmeaMessageListener implements NmeaListener {

    private ReactApplicationContext reactContext;

    public NmeaMessageListener(ReactApplicationContext reactContext) {
        this.reactContext = reactContext;
    }

    public void onNmeaReceived(long timestamp, String message) {
        WritableMap params = Arguments.createMap();
        params.putString("message", message);
        params.putDouble("timestamp", timestamp);

        this.sendEvent(reactContext, "onNmeaReceive", params);
    }

    private void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}