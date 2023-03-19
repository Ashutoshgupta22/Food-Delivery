package com.example.fooddelivery.view.activity

import android.Manifest
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.fooddelivery.Contract
import com.example.fooddelivery.databinding.ActivityMapBinding
import com.example.fooddelivery.model.LocationServicesProvider
import com.example.fooddelivery.presenter.MapPresenter
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.io.IOException
import java.util.*

class MapActivity : AppCompatActivity() ,Contract.View.MapView{

    lateinit var binding: ActivityMapBinding
    lateinit var nowLatLng : LatLng

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MapPresenter().getLastLocation(this,this,savedInstanceState)



    }

    override fun showMap(savedInstanceState: Bundle?, location: Location) {

        MapsInitializer.initialize(this)
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.onResume()
        binding.mapView.getMapAsync{

            val latLng = LatLng(location.latitude,location.longitude)
            val marker = it.addMarker( MarkerOptions()
                .position(latLng)
                .title("Set Location")
                .draggable(false)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)))


            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.

                Log.e("MapActivity", "showMap: Permission not granted" )

            }

            it.isMyLocationEnabled = true
            it.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            it.uiSettings.isZoomControlsEnabled = true
            it.animateCamera(CameraUpdateFactory.zoomTo(15f),1000,null)

            it.setOnCameraMoveStartedListener {
                Log.w("MapActivity", "showGoogleMaps: Camera move started")

                if (marker != null) {
                    marker.isDraggable = false
                    binding.addressView.text = ""
                    binding.addressView.hint = "Loading.."

                } else Log.e(
                    "MapActivity",
                    "showGoogleMaps: CameraMoveStartedListener  marker is null"
                )
            }

            it.setOnCameraMoveListener {
                val midLatLng: LatLng = it.cameraPosition.target
                marker?.setPosition(midLatLng)
                    ?: Log.e("MapActivity", "showGoogleMaps: cameraMoveListener marker is null")
            }

            it.setOnCameraIdleListener {
                Log.w("MapActivity", "showGoogleMaps: Camera idle getting address")
                val midLatLng: LatLng = it.cameraPosition.target
                if (marker != null) {
                    marker.position = midLatLng
                    nowLatLng = marker.position
                    Log.i(
                        "MainActivity", "showGoogleMaps: nowLocation= " +
                                nowLatLng.longitude + " " + nowLatLng.latitude
                    )
                    getAddressText(nowLatLng)
                } else Log.e(
                    "MapActivity",
                    "showGoogleMaps: cameraIdleListener marker is null"
                )
            }

        }

        binding.saveLocationBtn.setOnClickListener {

            Log.i("MapActivity", "onCreate: location confirmed ")

            location.latitude = nowLatLng.latitude
            location.longitude = nowLatLng.longitude

            val sharedPreferences = getSharedPreferences(packageName, MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("latitude",location.latitude.toString())
            editor.putString("longitude",location.longitude.toString())
            editor.apply()

            Toast.makeText(this, "Location saved", Toast.LENGTH_SHORT).show()

            finish()
        }

    }

    private fun getAddressText(nowLatLng: LatLng) {

        var addresses: List<Address>? = null
        val geocoder = Geocoder(this, Locale.getDefault())

        try {
            addresses = geocoder.getFromLocation(nowLatLng.latitude, nowLatLng.longitude, 1)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        if (addresses != null && addresses.isNotEmpty()) {
            val address = addresses[0].getAddressLine(0)
            Log.d("TAG", "getAddressText() returned: $address")
            binding.addressView.text = address
        } else Log.e("MapActivity", "getAddressText: Address returned is null")
    }

}