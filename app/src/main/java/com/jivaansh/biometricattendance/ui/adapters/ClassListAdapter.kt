package com.jivaansh.biometricattendance.ui.adapters

import com.jivaansh.biometricattendance.R
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jivaansh.biometricattendance.databinding.ItemClassBinding

class ClassListAdapter : RecyclerView.Adapter<ClassListAdapter.ClassViewHolder>() {

    private val classes = mutableListOf<ClassData>()

    inner class ClassViewHolder(val binding: ItemClassBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassViewHolder {
        val binding = ItemClassBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ClassViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClassViewHolder, position: Int) {
        val item = classes[position]
        holder.binding.tvClassName.text = item.className
        holder.binding.tvTeacher.text = item.teacherName
        holder.binding.ibEdit.setImageResource(R.drawable.edit)
    }

    override fun getItemCount() = classes.size
}

data class ClassData(val className: String, val teacherName: String)
