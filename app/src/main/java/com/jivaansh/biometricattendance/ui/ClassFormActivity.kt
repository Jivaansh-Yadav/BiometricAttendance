package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jivaansh.biometricattendance.databinding.ActivityClassFormBinding

class ClassFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Image and Save button
        binding.ivPhoto.setImageResource(R.drawable.edit)
        binding.btnSave.setImageResource(R.drawable.plus)
    }
}
