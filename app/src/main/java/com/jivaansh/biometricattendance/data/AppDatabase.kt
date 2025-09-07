package com.jivaansh.biometricattendance.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jivaansh.biometricattendance.data.dao.*
import com.jivaansh.biometricattendance.data.entities.*

@Database(
    entities = [ClassEntity::class, StudentEntity::class, AttendanceEntity::class, HolidayEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun classDao(): ClassDao
    abstract fun studentDao(): StudentDao
    abstract fun attendanceDao(): AttendanceDao
    abstract fun holidayDao(): HolidayDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val inst = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "biometric_attendance_db").build()
                INSTANCE = inst
                inst
            }
        }
    }
}
