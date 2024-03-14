package com.example.project_transitrace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class SecondActivity : AppCompatActivity() {

    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var buttonTrack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.user_page)

        // Initialize UI components
        editTextFrom = findViewById(R.id.editTextFrom)
        editTextTo = findViewById(R.id.editTextTo)
        buttonTrack = findViewById(R.id.buttonTrack)

        // Set onClickListener for the Track button
        buttonTrack.setOnClickListener {
            val fromStation = editTextFrom.text.toString()
            val toStation = editTextTo.text.toString()

            // Check if any field is empty
            if (fromStation.isEmpty() || toStation.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Implement train tracking logic based on the from and to stations
            // This is where you can fetch train information and display it to the user.
        }
    }
}
