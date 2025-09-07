package com.jivaansh.biometricattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jivaansh.biometricattendance.data.entities.AttendanceEntity

@Dao
interface AttendanceDao {
    @Query("SELECT * FROM attendance WHERE classId = :classId AND dateISO = :dateISO")
    fun getAttendanceForClassDate(classId: Long, dateISO: String): LiveData<List<AttendanceEntity>>

    @Query("SELECT * FROM attendance WHERE studentId = :studentId ORDER BY dateISO DESC")
    fun getAttendanceForStudent(studentId: Long): LiveData<List<AttendanceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAttendance(a: AttendanceEntity): Long

    @Query("DELETE FROM attendance WHERE classId = :classId AND dateISO = :dateISO")
    suspend fun clearAttendanceForClassDate(classId: Long, dateISO: String)
}
