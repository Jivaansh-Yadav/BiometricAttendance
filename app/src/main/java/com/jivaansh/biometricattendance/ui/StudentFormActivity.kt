package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jivaansh.biometricattendance.databinding.ActivityStudentFormBinding

class StudentFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivPhoto.setImageResource(R.drawable.edit)
        binding.btnSave.setImageResource(R.drawable.plus)
    }
}
