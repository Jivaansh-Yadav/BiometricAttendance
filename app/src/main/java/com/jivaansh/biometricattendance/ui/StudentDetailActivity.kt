package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jivaansh.biometricattendance.databinding.ActivityStudentDetailBinding

class StudentDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAttendance.text = "Attendance Details"
        binding.btnExport.setImageResource(R.drawable.paper)
    }
}
