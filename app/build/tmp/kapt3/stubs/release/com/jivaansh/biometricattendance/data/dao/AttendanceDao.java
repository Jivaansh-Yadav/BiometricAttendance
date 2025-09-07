package com.jivaansh.biometricattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0005H\'J\u0019\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/jivaansh/biometricattendance/data/dao/AttendanceDao;", "", "clearAttendanceForClassDate", "", "classId", "", "dateISO", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAttendanceForClassDate", "Landroidx/lifecycle/LiveData;", "", "Lcom/jivaansh/biometricattendance/data/entities/AttendanceEntity;", "getAttendanceForStudent", "studentId", "insertAttendance", "a", "(Lcom/jivaansh/biometricattendance/data/entities/AttendanceEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao
public abstract interface AttendanceDao {
    
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE classId = :classId AND dateISO = :dateISO")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.jivaansh.biometricattendance.data.entities.AttendanceEntity>> getAttendanceForClassDate(long classId, @org.jetbrains.annotations.NotNull
    java.lang.String dateISO);
    
    @androidx.room.Query(value = "SELECT * FROM attendance WHERE studentId = :studentId ORDER BY dateISO DESC")
    @org.jetbrains.annotations.NotNull
    public abstract androidx.lifecycle.LiveData<java.util.List<com.jivaansh.biometricattendance.data.entities.AttendanceEntity>> getAttendanceForStudent(long studentId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertAttendance(@org.jetbrains.annotations.NotNull
    com.jivaansh.biometricattendance.data.entities.AttendanceEntity a, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "DELETE FROM attendance WHERE classId = :classId AND dateISO = :dateISO")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearAttendanceForClassDate(long classId, @org.jetbrains.annotations.NotNull
    java.lang.String dateISO, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}