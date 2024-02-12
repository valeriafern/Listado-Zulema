package com.example.coneccionbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.LatLngBounds
import com.example.coneccionbd.databinding.ActivityMapsBinding



class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(2.4832482, -76.56177339999999)
        mMap.addMarker(MarkerOptions().position(sydney).title("estoy en el sena"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))


        val sydney2 = LatLng(2.4426012180800933,  -76.60512304890526)
        mMap.addMarker(MarkerOptions().position(sydney2).title("estoy en el parque"))

        val sydney3 = LatLng(2.4345, -76.6224) // Reemplazar latitud2 y longitud2 con las coordenadas de la segunda ubicación adicional
        mMap.addMarker(MarkerOptions().position(sydney3).title("estoy en el morro"))

        val builder = LatLngBounds.Builder()
        builder.include(sydney)
        builder.include(sydney2)
        builder.include(sydney3)
        val bounds = builder.build()
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
    }

}
