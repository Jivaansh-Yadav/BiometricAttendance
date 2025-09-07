package com.jivaansh.biometricattendance.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/jivaansh/biometricattendance/data/dao/HolidayDao;", "", "getHolidayForClassDate", "Lcom/jivaansh/biometricattendance/data/entities/HolidayEntity;", "classId", "", "dateISO", "", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHoliday", "h", "(Lcom/jivaansh/biometricattendance/data/entities/HolidayEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface HolidayDao {
    
    @androidx.room.Query(value = "SELECT * FROM holidays WHERE classId = :classId AND dateISO = :dateISO LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHolidayForClassDate(long classId, @org.jetbrains.annotations.NotNull
    java.lang.String dateISO, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.jivaansh.biometricattendance.data.entities.HolidayEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHoliday(@org.jetbrains.annotations.NotNull
    com.jivaansh.biometricattendance.data.entities.HolidayEntity h, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}