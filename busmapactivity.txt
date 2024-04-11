package com.example.transitrace
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.*

class UserBusMapActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var liveLocationRef: DatabaseReference
    private lateinit var busKey: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_bus_map)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Get the busKey from the intent
        busKey = intent.getStringExtra("busKey") ?: ""

        // Get the reference to the "live_location" subcollection
        liveLocationRef = FirebaseDatabase.getInstance().getReference("live_track_bus").child(busKey).child("live_location")
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Listen for changes in the live_location subcollection
        liveLocationRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Clear existing markers
                mMap.clear()

                // Fetch the latest live location data
                val latitude = dataSnapshot.child("latitude").getValue(Double::class.java)
                val longitude = dataSnapshot.child("longitude").getValue(Double::class.java)

                // If location data exists, add a marker on the map
                if (latitude != null && longitude != null) {
                    val location = LatLng(latitude, longitude)
                    mMap.addMarker(MarkerOptions().position(location).title("Bus Location"))
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15f))
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle database error
            }
        })
    }
}
