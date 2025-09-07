package com.jivaansh.biometricattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jivaansh.biometricattendance.data.entities.ClassEntity

@Dao
interface ClassDao {
    @Query("SELECT * FROM classes ORDER BY className")
    fun getAllClasses(): LiveData<List<ClassEntity>>

    @Query("SELECT * FROM classes WHERE id = :id LIMIT 1")
    suspend fun getClassById(id: Long): ClassEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClass(c: ClassEntity): Long

    @Update
    suspend fun updateClass(c: ClassEntity)

    @Delete
    suspend fun deleteClass(c: ClassEntity)
}
