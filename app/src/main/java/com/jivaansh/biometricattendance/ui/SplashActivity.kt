package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jivaansh.biometricattendance.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Splash GIF
        binding.splashGif.setImageResource(R.drawable.splashscreen)
        binding.tvMadeBy.text = "Made by Jivaansh"

        // Navigate to Class List after 2 seconds
        binding.root.postDelayed({
            startActivity(Intent(this, ClassListActivity::class.java))
            finish()
        }, 2000)
    }
}
