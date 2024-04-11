package com.example.transitrace;

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class AdminBusListActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val busList = listOf("Bus 1", "Bus 2", "Bus 3", "Bus 4", "Bus 5") // Example list of bus names

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bus_list)

        listView = findViewById(R.id.list_view)

        // Populate ListView with bus names
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, busList)
        listView.adapter = adapter

        // Set item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedBus = busList[position] // Get the selected bus
            navigateToBusMapActivity(selectedBus) // Navigate to BusMapActivity with the selected bus
        }
    }

    private fun navigateToBusMapActivity(selectedBus: String) {
        val intent = Intent(this, UserBusMapActivity::class.java)
        intent.putExtra("selectedBus", selectedBus) // Pass the selected bus name to BusMapActivity
        startActivity(intent)
    }
}
