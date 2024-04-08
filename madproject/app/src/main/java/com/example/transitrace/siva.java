package com.example.transitrace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Accessing a TextView from activity_main.xml
        TextView textView = findViewById(R.id.textView);

        // Example: Setting text to the TextView
        textView.setText("Hello, World!");
    }
}
