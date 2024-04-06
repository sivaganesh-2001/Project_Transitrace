package com.example.transitrace
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class UserSelectedBusListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var databaseRef: DatabaseReference
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var busKeys: MutableList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_selected_bus_list)

        listView = findViewById(R.id.list_view)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1)
        listView.adapter = adapter

        databaseRef = FirebaseDatabase.getInstance().getReference("live_track_bus")
        busKeys = mutableListOf()

        val from = intent.getStringExtra("from") ?: ""
        val to = intent.getStringExtra("to") ?: ""

        databaseRef.orderByChild("from").equalTo(from)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (!snapshot.exists()) {
                        // No buses available
                        adapter.add("No Buses Available")
                    } else {
                        snapshot.children.forEach { childSnapshot ->
                            val key = childSnapshot.key
                            val busData = childSnapshot.getValue(BusData::class.java)
                            busData?.let {
                                if (it.to == to) {
                                    key?.let { busKey ->
                                        busKeys.add(busKey)
                                        adapter.add("Bus: ${it.busNumber}, Route: ${it.busRoute}")
                                    }
                                }
                            }
                        }
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error
                }

                // Other overridden methods

            })

        // Set item click listener
        listView.setOnItemClickListener { _, _, position, _ ->
            if (busKeys.isNotEmpty() && position < busKeys.size) {
                val selectedBusKey = busKeys[position]
                val intent =
                    Intent(this@UserSelectedBusListActivity, UserBusMapActivity::class.java).apply {
                        putExtra("busKey", selectedBusKey)
                    }
                startActivity(intent)
            }
        }
    }
}