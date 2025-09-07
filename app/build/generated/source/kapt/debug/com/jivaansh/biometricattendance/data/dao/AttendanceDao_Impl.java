package com.jivaansh.biometricattendance.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.jivaansh.biometricattendance.data.entities.AttendanceEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AttendanceDao_Impl implements AttendanceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<AttendanceEntity> __insertionAdapterOfAttendanceEntity;

  private final SharedSQLiteStatement __preparedStmtOfClearAttendanceForClassDate;

  public AttendanceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAttendanceEntity = new EntityInsertionAdapter<AttendanceEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `attendance` (`id`,`classId`,`studentId`,`dateISO`,`present`,`timestamp`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final AttendanceEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClassId());
        statement.bindLong(3, entity.getStudentId());
        if (entity.getDateISO() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDateISO());
        }
        final int _tmp = entity.getPresent() ? 1 : 0;
        statement.bindLong(5, _tmp);
        statement.bindLong(6, entity.getTimestamp());
      }
    };
    this.__preparedStmtOfClearAttendanceForClassDate = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM attendance WHERE classId = ? AND dateISO = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAttendance(final AttendanceEntity a,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAttendanceEntity.insertAndReturnId(a);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object clearAttendanceForClassDate(final long classId, final String dateISO,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfClearAttendanceForClassDate.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, classId);
        _argIndex = 2;
        if (dateISO == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, dateISO);
        }
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfClearAttendanceForClassDate.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<AttendanceEntity>> getAttendanceForClassDate(final long classId,
      final String dateISO) {
    final String _sql = "SELECT * FROM attendance WHERE classId = ? AND dateISO = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    _argIndex = 2;
    if (dateISO == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateISO);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance"}, false, new Callable<List<AttendanceEntity>>() {
      @Override
      @Nullable
      public List<AttendanceEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfDateISO = CursorUtil.getColumnIndexOrThrow(_cursor, "dateISO");
          final int _cursorIndexOfPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "present");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<AttendanceEntity> _result = new ArrayList<AttendanceEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final long _tmpStudentId;
            _tmpStudentId = _cursor.getLong(_cursorIndexOfStudentId);
            final String _tmpDateISO;
            if (_cursor.isNull(_cursorIndexOfDateISO)) {
              _tmpDateISO = null;
            } else {
              _tmpDateISO = _cursor.getString(_cursorIndexOfDateISO);
            }
            final boolean _tmpPresent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPresent);
            _tmpPresent = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new AttendanceEntity(_tmpId,_tmpClassId,_tmpStudentId,_tmpDateISO,_tmpPresent,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<AttendanceEntity>> getAttendanceForStudent(final long studentId) {
    final String _sql = "SELECT * FROM attendance WHERE studentId = ? ORDER BY dateISO DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"attendance"}, false, new Callable<List<AttendanceEntity>>() {
      @Override
      @Nullable
      public List<AttendanceEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfDateISO = CursorUtil.getColumnIndexOrThrow(_cursor, "dateISO");
          final int _cursorIndexOfPresent = CursorUtil.getColumnIndexOrThrow(_cursor, "present");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final List<AttendanceEntity> _result = new ArrayList<AttendanceEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final AttendanceEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final long _tmpStudentId;
            _tmpStudentId = _cursor.getLong(_cursorIndexOfStudentId);
            final String _tmpDateISO;
            if (_cursor.isNull(_cursorIndexOfDateISO)) {
              _tmpDateISO = null;
            } else {
              _tmpDateISO = _cursor.getString(_cursorIndexOfDateISO);
            }
            final boolean _tmpPresent;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfPresent);
            _tmpPresent = _tmp != 0;
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            _item = new AttendanceEntity(_tmpId,_tmpClassId,_tmpStudentId,_tmpDateISO,_tmpPresent,_tmpTimestamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
