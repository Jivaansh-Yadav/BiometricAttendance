package com.jivaansh.biometricattendance.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "classes")
data class ClassEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val className: String,
    val teacherName: String,
    val teacherGender: String? = null,
    val schoolName: String? = null,
    val teacherPhotoPath: String? = null,
    val teacherKeyAlias: String? = null
)
