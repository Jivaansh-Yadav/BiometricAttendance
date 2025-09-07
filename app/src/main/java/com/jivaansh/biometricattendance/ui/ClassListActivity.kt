package com.jivaansh.biometricattendance.ui

import com.jivaansh.biometricattendance.R
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jivaansh.biometricattendance.databinding.ActivityClassListBinding
import com.jivaansh.biometricattendance.ui.adapters.ClassListAdapter

class ClassListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityClassListBinding
    private lateinit var adapter: ClassListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClassListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView
        adapter = ClassListAdapter()
        binding.recyclerClasses.layoutManager = LinearLayoutManager(this)
        binding.recyclerClasses.adapter = adapter

        // Add new class
        binding.fabAdd.setImageResource(R.drawable.plus)
        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this, ClassFormActivity::class.java))
        }

        // Empty text
        binding.tvEmpty.text = "No classes yet"
    }
}
