package com.jivaansh.biometricattendance.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.jivaansh.biometricattendance.data.entities.StudentEntity;
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
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StudentEntity> __insertionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __deletionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __updateAdapterOfStudentEntity;

  public StudentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudentEntity = new EntityInsertionAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `students` (`id`,`classId`,`studentName`,`studentGender`,`studentPhotoPath`,`studentKeyAlias`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClassId());
        if (entity.getStudentName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStudentName());
        }
        if (entity.getStudentGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStudentGender());
        }
        if (entity.getStudentPhotoPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStudentPhotoPath());
        }
        if (entity.getStudentKeyAlias() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStudentKeyAlias());
        }
      }
    };
    this.__deletionAdapterOfStudentEntity = new EntityDeletionOrUpdateAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `students` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfStudentEntity = new EntityDeletionOrUpdateAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `students` SET `id` = ?,`classId` = ?,`studentName` = ?,`studentGender` = ?,`studentPhotoPath` = ?,`studentKeyAlias` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClassId());
        if (entity.getStudentName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getStudentName());
        }
        if (entity.getStudentGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStudentGender());
        }
        if (entity.getStudentPhotoPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getStudentPhotoPath());
        }
        if (entity.getStudentKeyAlias() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getStudentKeyAlias());
        }
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insertStudent(final StudentEntity s, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfStudentEntity.insertAndReturnId(s);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteStudent(final StudentEntity s, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfStudentEntity.handle(s);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateStudent(final StudentEntity s, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStudentEntity.handle(s);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<StudentEntity>> getStudentsForClass(final long classId) {
    final String _sql = "SELECT * FROM students WHERE classId = ? ORDER BY studentName";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, classId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"students"}, false, new Callable<List<StudentEntity>>() {
      @Override
      @Nullable
      public List<StudentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfStudentGender = CursorUtil.getColumnIndexOrThrow(_cursor, "studentGender");
          final int _cursorIndexOfStudentPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "studentPhotoPath");
          final int _cursorIndexOfStudentKeyAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "studentKeyAlias");
          final List<StudentEntity> _result = new ArrayList<StudentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final String _tmpStudentGender;
            if (_cursor.isNull(_cursorIndexOfStudentGender)) {
              _tmpStudentGender = null;
            } else {
              _tmpStudentGender = _cursor.getString(_cursorIndexOfStudentGender);
            }
            final String _tmpStudentPhotoPath;
            if (_cursor.isNull(_cursorIndexOfStudentPhotoPath)) {
              _tmpStudentPhotoPath = null;
            } else {
              _tmpStudentPhotoPath = _cursor.getString(_cursorIndexOfStudentPhotoPath);
            }
            final String _tmpStudentKeyAlias;
            if (_cursor.isNull(_cursorIndexOfStudentKeyAlias)) {
              _tmpStudentKeyAlias = null;
            } else {
              _tmpStudentKeyAlias = _cursor.getString(_cursorIndexOfStudentKeyAlias);
            }
            _item = new StudentEntity(_tmpId,_tmpClassId,_tmpStudentName,_tmpStudentGender,_tmpStudentPhotoPath,_tmpStudentKeyAlias);
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
  public Object getStudentById(final long id,
      final Continuation<? super StudentEntity> $completion) {
    final String _sql = "SELECT * FROM students WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<StudentEntity>() {
      @Override
      @Nullable
      public StudentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassId = CursorUtil.getColumnIndexOrThrow(_cursor, "classId");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfStudentGender = CursorUtil.getColumnIndexOrThrow(_cursor, "studentGender");
          final int _cursorIndexOfStudentPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "studentPhotoPath");
          final int _cursorIndexOfStudentKeyAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "studentKeyAlias");
          final StudentEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClassId;
            _tmpClassId = _cursor.getLong(_cursorIndexOfClassId);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final String _tmpStudentGender;
            if (_cursor.isNull(_cursorIndexOfStudentGender)) {
              _tmpStudentGender = null;
            } else {
              _tmpStudentGender = _cursor.getString(_cursorIndexOfStudentGender);
            }
            final String _tmpStudentPhotoPath;
            if (_cursor.isNull(_cursorIndexOfStudentPhotoPath)) {
              _tmpStudentPhotoPath = null;
            } else {
              _tmpStudentPhotoPath = _cursor.getString(_cursorIndexOfStudentPhotoPath);
            }
            final String _tmpStudentKeyAlias;
            if (_cursor.isNull(_cursorIndexOfStudentKeyAlias)) {
              _tmpStudentKeyAlias = null;
            } else {
              _tmpStudentKeyAlias = _cursor.getString(_cursorIndexOfStudentKeyAlias);
            }
            _result = new StudentEntity(_tmpId,_tmpClassId,_tmpStudentName,_tmpStudentGender,_tmpStudentPhotoPath,_tmpStudentKeyAlias);
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
