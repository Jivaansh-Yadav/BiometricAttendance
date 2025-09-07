package com.jivaansh.biometricattendance.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val classId: Long,
    val studentId: Long,
    val dateISO: String,    // e.g. "2025-09-05"
    val present: Boolean,
    val timestamp: Long = System.currentTimeMillis()
)
