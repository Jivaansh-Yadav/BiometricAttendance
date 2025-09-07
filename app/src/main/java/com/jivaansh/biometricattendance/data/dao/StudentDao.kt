package com.jivaansh.biometricattendance.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jivaansh.biometricattendance.data.entities.StudentEntity

@Dao
interface StudentDao {
    @Query("SELECT * FROM students WHERE classId = :classId ORDER BY studentName")
    fun getStudentsForClass(classId: Long): LiveData<List<StudentEntity>>

    @Query("SELECT * FROM students WHERE id = :id LIMIT 1")
    suspend fun getStudentById(id: Long): StudentEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(s: StudentEntity): Long

    @Update
    suspend fun updateStudent(s: StudentEntity)

    @Delete
    suspend fun deleteStudent(s: StudentEntity)
}
