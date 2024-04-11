package com.example.transitrace
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class UserHomeActivity : AppCompatActivity() {

    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var buttonSubmit: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
        val profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            showProfileMenu()
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

    private fun showProfileMenu() {
        val profile = findViewById<ImageView>(R.id.profile)
        val popupMenu = PopupMenu(this, profile)
        popupMenu.menuInflater.inflate(R.menu.profile_menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.login -> {
                    // Handle login action by starting LoginActivity
                    startActivity(Intent(this, LoginActivity::class.java))
                    true // Return true to consume the click event
                }
                R.id.feedback -> {
                    // Handle account profile action
                    Toast.makeText(this, "Account Profile clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.complaint -> {
                    // Handle complaint action
                    Toast.makeText(this, "Complaint clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
        popupMenu.show()
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

