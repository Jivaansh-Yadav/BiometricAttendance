package com.jivaansh.biometricattendance.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "holidays")
data class HolidayEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val classId: Long,
    val dateISO: String,
    val holidayName: String
)
