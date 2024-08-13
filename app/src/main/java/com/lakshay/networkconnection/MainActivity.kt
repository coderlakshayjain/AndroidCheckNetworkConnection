package com.lakshay.networkconnection

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inflateLayout = findViewById<View>(R.id.networkError)
        val hideLayout = findViewById<TextView>(R.id.text)
        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this) {
            if (it) {
                hideLayout.visibility = View.VISIBLE
                inflateLayout.visibility = View.GONE
                Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show()
            } else {
                inflateLayout.visibility = View.VISIBLE
                hideLayout.visibility = View.GONE
                Toast.makeText(this, "Not Connected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}