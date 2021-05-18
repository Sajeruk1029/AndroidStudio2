package com.sajeruk.myapplication

import android.app.Activity
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationProvider
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    //private lateinit var mMap: GoogleMap

    var currentLocation : Location? = null
    var fusedLocationProviderClient : FusedLocationProviderClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //val mapFragment = supportFragmentManager
         //       .findFragmentById(R.id.map) as SupportMapFragment
        //mapFragment.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        fetchLocation()
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        //mMap = googleMap

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        Log.d("DEBUG", currentLocation!!.latitude.toString())
        Log.d("DEBUG", currentLocation!!.longitude.toString())

        val markerOptions : MarkerOptions = MarkerOptions().position(LatLng(currentLocation!!.latitude, currentLocation!!.longitude)).title("I")

        googleMap.animateCamera(CameraUpdateFactory.newLatLng(LatLng(currentLocation!!.latitude, currentLocation!!.longitude)))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(currentLocation!!.latitude, currentLocation!!.longitude), 5f))
        googleMap.addMarker(markerOptions)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when(requestCode){
            200 -> if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                fetchLocation()
            }
        }
    }

    private fun fetchLocation() {

        var supportMapFragment: SupportMapFragment? = null

        if((ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 200)
            return
        }

        fusedLocationProviderClient!!.lastLocation.addOnSuccessListener {

            if(it != null) {
                currentLocation = it

                Toast.makeText(this, currentLocation!!.latitude.toString() + " " + currentLocation!!.longitude.toString(), Toast.LENGTH_SHORT).show()
            }

            supportMapFragment = (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)!!

            supportMapFragment!!.getMapAsync(this)
        }
    }


}