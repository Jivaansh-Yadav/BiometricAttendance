package com.jivaansh.biometricattendance.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.jivaansh.biometricattendance.data.entities.HolidayEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.coroutines.Continuation;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class HolidayDao_Impl implements HolidayDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<HolidayEntity> __insertionAdapterOfHolidayEntity;

  public HolidayDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfHolidayEntity = new EntityInsertionAdapter<HolidayEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `holidays` (`id`,`classId`,`dateISO`,`holidayName`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final HolidayEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClassId());
        if (entity.getDateISO() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDateISO());
        }
        if (entity.getHolidayName() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getHolidayName());
        }
      }
    };
  }

  @Override
  public Object insertHoliday(final HolidayEntity h, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfHolidayEntity.insertAndReturnId(h);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object getHolidayForClassDate(final long classId, final String dateISO,
      final Continuation<? super HolidayEntity> $completion) {
    final String _sql = "SELECT * FROM holidays WHERE classId = ? AND dateISO = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    _argIndex = 2;
    if (dateISO == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dateISO);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<HolidayEntity>() {
      @Override
      @Nullable
      public HolidayEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfDateISO = CursorUtil.getColumnIndexOrThrow(_cursor, "dateISO");
          final int _cursorIndexOfHolidayName = CursorUtil.getColumnIndexOrThrow(_cursor, "holidayName");
          final HolidayEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpDateISO;
            if (_cursor.isNull(_cursorIndexOfDateISO)) {
              _tmpDateISO = null;
            } else {
              _tmpDateISO = _cursor.getString(_cursorIndexOfDateISO);
            }
            final String _tmpHolidayName;
            if (_cursor.isNull(_cursorIndexOfHolidayName)) {
              _tmpHolidayName = null;
            } else {
              _tmpHolidayName = _cursor.getString(_cursorIndexOfHolidayName);
            }
            _result = new HolidayEntity(_tmpId,_tmpClassId,_tmpDateISO,_tmpHolidayName);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
