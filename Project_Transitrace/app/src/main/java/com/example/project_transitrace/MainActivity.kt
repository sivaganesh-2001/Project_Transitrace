package com.example.project_transitrace
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity




class MainActivity : AppCompatActivity() {

    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var buttonTrack: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        editTextFrom = findViewById(R.id.editTextFrom)
        editTextTo = findViewById(R.id.editTextTo)
        buttonTrack = findViewById(R.id.buttonTrack)
    }
}
