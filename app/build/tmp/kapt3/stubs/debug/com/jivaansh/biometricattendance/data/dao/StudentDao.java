package com.jivaansh.biometricattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\tH\'J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/jivaansh/biometricattendance/data/dao/StudentDao;", "", "deleteStudent", "", "s", "Lcom/jivaansh/biometricattendance/data/entities/StudentEntity;", "(Lcom/jivaansh/biometricattendance/data/entities/StudentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudentById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStudentsForClass", "Landroidx/lifecycle/LiveData;", "", "classId", "insertStudent", "updateStudent", "app_debug"})
@androidx.room.Dao
public abstract interface StudentDao {
    
    @androidx.room.Query(value = "SELECT * FROM students WHERE classId = :classId ORDER BY studentName")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.jivaansh.biometricattendance.data.entities.StudentEntity>> getStudentsForClass(long classId);
    
    @androidx.room.Query(value = "SELECT * FROM students WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStudentById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jivaansh.biometricattendance.data.entities.StudentEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertStudent(@org.jetbrains.annotations.NotNull
    com.jivaansh.biometricattendance.data.entities.StudentEntity s, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateStudent(@org.jetbrains.annotations.NotNull
    com.jivaansh.biometricattendance.data.entities.StudentEntity s, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteStudent(@org.jetbrains.annotations.NotNull
    com.jivaansh.biometricattendance.data.entities.StudentEntity s, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}