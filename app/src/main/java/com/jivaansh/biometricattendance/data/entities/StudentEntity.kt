package com.jivaansh.biometricattendance.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val classId: Long,
    val studentName: String,
    val studentGender: String? = null,
    val studentPhotoPath: String? = null,
    val studentKeyAlias: String? = null
)
