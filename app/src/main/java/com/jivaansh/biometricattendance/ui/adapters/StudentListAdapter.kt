package com.jivaansh.biometricattendance.ui.adapters

import com.jivaansh.biometricattendance.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jivaansh.biometricattendance.databinding.ItemStudentBinding

class StudentListAdapter : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    private val students = mutableListOf<StudentData>()

    inner class StudentViewHolder(val binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.binding.tvName.text = student.name
        holder.binding.ivPhoto.setImageResource(R.drawable.edit)
        holder.binding.ibEdit.setImageResource(R.drawable.edit)
    }

    override fun getItemCount() = students.size
}

data class StudentData(val name: String)
