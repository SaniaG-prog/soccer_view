package com.example.soccerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.soccerview.features.splash_screen.SplashScreenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.activity_fragment_container, SplashScreenFragment.newInstance())
            .addToBackStack(null).commit()
    }
}