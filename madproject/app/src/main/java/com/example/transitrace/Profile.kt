package com.example.transitrace
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.transitrace.R

// Inside your fragment class
// Inside your fragment class
class Profile : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Assuming you have a button in your fragment layout with id "profile"
        val button: Button = view.findViewById(R.id.profile)

        // Set click listener for the button
        button.setOnClickListener {
            // Create an intent to start the LoginActivity
            val intent = Intent(activity, LoginActivity::class.java)

            // Start the LoginActivity
            startActivity(intent)
        }
    }
}
