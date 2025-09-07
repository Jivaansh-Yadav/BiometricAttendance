package com.jivaansh.biometricattendance.data.dao

import androidx.room.*
import com.jivaansh.biometricattendance.data.entities.HolidayEntity

@Dao
interface HolidayDao {
    @Query("SELECT * FROM holidays WHERE classId = :classId AND dateISO = :dateISO LIMIT 1")
    suspend fun getHolidayForClassDate(classId: Long, dateISO: String): HolidayEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHoliday(h: HolidayEntity): Long
}
