package com.jivaansh.biometricattendance.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.jivaansh.biometricattendance.R
import pl.droidsonroids.gif.GifImageView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Show splashscreen.gif automatically via GifImageView in XML
        val splashDuration: Long = 2000 // 2 seconds

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ClassListActivity::class.java)
            startActivity(intent)
            finish()
        }, splashDuration)
    }
}
