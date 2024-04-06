package com.example.transitrace
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.libraries.places.api.Places


class UserHomeActivity : AppCompatActivity() {

    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        Places.initialize(applicationContext, "AIzaSyD2SC7a2Yy3frl_92aQ1POI1QUXagOA25w") // Initialize Firebase
        val profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            val intent = Intent(this, DrawerActivity::class.java)
// Start Activity B
            startActivity(intent)
        }
        editTextFrom = findViewById(R.id.editTextFrom)
        editTextTo = findViewById(R.id.editTextTo)
        buttonSubmit = findViewById(R.id.buttonTrack)
        buttonReset = findViewById(R.id.buttonReset)

        buttonSubmit.setOnClickListener {
            navigateToBusListActivity()
        }

        buttonReset.setOnClickListener {
            resetFields()
        }
    }



    private fun navigateToBusListActivity() {
        val from = editTextFrom.text.toString().trim().lowercase() // Trim extra spaces and convert to lowercase
        val to = editTextTo.text.toString().trim().lowercase() // Trim extra spaces and convert to lowercase

        val intent = Intent(this, UserSelectedBusListActivity::class.java)
        intent.putExtra("from", from)
        intent.putExtra("to", to)
        startActivity(intent)
    }


    private fun resetFields() {
        editTextFrom.text.clear()
        editTextTo.text.clear()
    }
}

