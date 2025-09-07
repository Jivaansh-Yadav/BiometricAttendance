package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jivaansh.biometricattendance.databinding.ActivityClassDetailBinding
import com.jivaansh.biometricattendance.ui.adapters.StudentListAdapter

class ClassDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassDetailBinding
    private lateinit var adapter: StudentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Students RecyclerView
        adapter = StudentListAdapter()
        binding.recyclerStudents.layoutManager = LinearLayoutManager(this)
        binding.recyclerStudents.adapter = adapter

        // Buttons
        binding.fabAddStudent.setImageResource(R.drawable.plus)
        binding.fabStart.setImageResource(R.drawable.startattendance)
        binding.btnHoliday.setImageResource(R.drawable.holiday)
        binding.btnData.setImageResource(R.drawable.paper)

        // Instructions
        binding.tvInstruction.text = "Tap a student to mark attendance"
    }
}
