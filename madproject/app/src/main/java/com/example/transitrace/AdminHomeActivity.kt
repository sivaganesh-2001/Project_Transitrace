package com.example.transitrace
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class AdminHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        // Find views
        val imageViewProfile: ImageView = findViewById(R.id.imageViewProfile)
        val driverCardView = findViewById<CardView>(R.id.driver)
        val trackCardView = findViewById<CardView>(R.id.Track)
        val emergencyCardView = findViewById<CardView>(R.id.emergency)
        val busListCardView = findViewById<CardView>(R.id.buslist)
        val complaintCardView = findViewById<CardView>(R.id.complaint)
        val userCardView = findViewById<CardView>(R.id.user)

        val profile = findViewById<ImageView>(R.id.profile)
        profile.setOnClickListener {
            val intent = Intent(this, DrawerActivity::class.java)
// Start Activity B
            startActivity(intent)
        }
        driverCardView.setOnClickListener {
            // Replace ManageDriverActivity::class.java with your desired activity
            val intent = Intent(this, AdminManageDriverActivity::class.java)
            startActivity(intent)
        }

        trackCardView.setOnClickListener {
            // Replace TrackBusActivity::class.java with your desired activity
            val intent = Intent(this, TrackBusActivity::class.java)
            startActivity(intent)
        }

        emergencyCardView.setOnClickListener {
            // Replace EmergencyActivity::class.java with your desired activity
            val intent = Intent(this, AdminEmergencyActivity::class.java)
            startActivity(intent)
        }

        busListCardView.setOnClickListener {
            // Replace BusListActivity::class.java with your desired activity
            val intent = Intent(this, AdminManageBusListActivity::class.java)
            startActivity(intent)
        }

        complaintCardView.setOnClickListener {
            // Replace ComplaintsActivity::class.java with your desired activity
            val intent = Intent(this, AdminComplaintsActivity::class.java)
            startActivity(intent)
        }

        userCardView.setOnClickListener {
            // Replace ManageUserActivity::class.java with your desired activity
            val intent = Intent(this, AdminManageUserActivity::class.java)
            startActivity(intent)
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
}
