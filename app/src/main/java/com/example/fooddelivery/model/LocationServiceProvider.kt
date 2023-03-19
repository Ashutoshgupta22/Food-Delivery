package com.example.fooddelivery.model

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.AbsSavedState
import androidx.core.app.ActivityCompat
import com.example.fooddelivery.Contract
import com.example.fooddelivery.presenter.MapPresenter
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class LocationServicesProvider(var context: Context) {

        private val locationProviderClient = LocationServices.getFusedLocationProviderClient(context)
        private var lastLocation: Location? = null

    fun getLastLocation(mapView : Contract.View.MapView ,savedInstanceState: Bundle?): Location? {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) !=
                PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) !=
                PackageManager.PERMISSION_GRANTED
            ) {

                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                Log.w("LocationServicesProvider", "getLastLocation: Permission not granted")
                return null
            }
            locationProviderClient.lastLocation
                .addOnSuccessListener(context as Activity) { location ->
                    if (location != null) {
                        Log.d("LocationServiceProvider", "onSuccess() returned: " + location.longitude + " " + location.latitude)

                        lastLocation = location

                        Log.i("LocationServicesProvider", "getLastLocation: calling mapActivity methods")
                        mapView.showMap(savedInstanceState, location)

                    } else {

                        //since we have used getLastLocation method
                        //location is null when previously no client has accessed location.
                        // It usually happens in emulator or new device. So open Maps at least once before calling this method.

                        //TODO to prevent this use getCurrentLocation method instead of getLastLocation.
                        Log.e(
                            "LocationServiceProvider",
                            "getLastLocation: Error Occurred location is null"
                        )
                        lastLocation = null
                    }
                }
            return lastLocation
        }
    }

