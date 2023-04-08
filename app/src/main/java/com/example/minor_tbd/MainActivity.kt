package com.example.minor_tbd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.FragmentHolder,Fragment_1_GreetingScreen()).commit()
        }
    }
}