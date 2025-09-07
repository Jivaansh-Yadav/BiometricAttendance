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
import com.jivaansh.biometricattendance.data.entities.ClassEntity;
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
public final class ClassDao_Impl implements ClassDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ClassEntity> __insertionAdapterOfClassEntity;

  private final EntityDeletionOrUpdateAdapter<ClassEntity> __deletionAdapterOfClassEntity;

  private final EntityDeletionOrUpdateAdapter<ClassEntity> __updateAdapterOfClassEntity;

  public ClassDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfClassEntity = new EntityInsertionAdapter<ClassEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `classes` (`id`,`className`,`teacherName`,`teacherGender`,`schoolName`,`teacherPhotoPath`,`teacherKeyAlias`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getClassName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getClassName());
        }
        if (entity.getTeacherName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTeacherName());
        }
        if (entity.getTeacherGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTeacherGender());
        }
        if (entity.getSchoolName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSchoolName());
        }
        if (entity.getTeacherPhotoPath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getTeacherPhotoPath());
        }
        if (entity.getTeacherKeyAlias() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTeacherKeyAlias());
        }
      }
    };
    this.__deletionAdapterOfClassEntity = new EntityDeletionOrUpdateAdapter<ClassEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `classes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfClassEntity = new EntityDeletionOrUpdateAdapter<ClassEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `classes` SET `id` = ?,`className` = ?,`teacherName` = ?,`teacherGender` = ?,`schoolName` = ?,`teacherPhotoPath` = ?,`teacherKeyAlias` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ClassEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getClassName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getClassName());
        }
        if (entity.getTeacherName() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTeacherName());
        }
        if (entity.getTeacherGender() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getTeacherGender());
        }
        if (entity.getSchoolName() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getSchoolName());
        }
        if (entity.getTeacherPhotoPath() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getTeacherPhotoPath());
        }
        if (entity.getTeacherKeyAlias() == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.getTeacherKeyAlias());
        }
        statement.bindLong(8, entity.getId());
      }
    };
  }

  @Override
  public Object insertClass(final ClassEntity c, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfClassEntity.insertAndReturnId(c);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteClass(final ClassEntity c, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfClassEntity.handle(c);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateClass(final ClassEntity c, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfClassEntity.handle(c);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<ClassEntity>> getAllClasses() {
    final String _sql = "SELECT * FROM classes ORDER BY className";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"classes"}, false, new Callable<List<ClassEntity>>() {
      @Override
      @Nullable
      public List<ClassEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfTeacherGender = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherGender");
          final int _cursorIndexOfSchoolName = CursorUtil.getColumnIndexOrThrow(_cursor, "schoolName");
          final int _cursorIndexOfTeacherPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherPhotoPath");
          final int _cursorIndexOfTeacherKeyAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherKeyAlias");
          final List<ClassEntity> _result = new ArrayList<ClassEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ClassEntity _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpTeacherGender;
            if (_cursor.isNull(_cursorIndexOfTeacherGender)) {
              _tmpTeacherGender = null;
            } else {
              _tmpTeacherGender = _cursor.getString(_cursorIndexOfTeacherGender);
            }
            final String _tmpSchoolName;
            if (_cursor.isNull(_cursorIndexOfSchoolName)) {
              _tmpSchoolName = null;
            } else {
              _tmpSchoolName = _cursor.getString(_cursorIndexOfSchoolName);
            }
            final String _tmpTeacherPhotoPath;
            if (_cursor.isNull(_cursorIndexOfTeacherPhotoPath)) {
              _tmpTeacherPhotoPath = null;
            } else {
              _tmpTeacherPhotoPath = _cursor.getString(_cursorIndexOfTeacherPhotoPath);
            }
            final String _tmpTeacherKeyAlias;
            if (_cursor.isNull(_cursorIndexOfTeacherKeyAlias)) {
              _tmpTeacherKeyAlias = null;
            } else {
              _tmpTeacherKeyAlias = _cursor.getString(_cursorIndexOfTeacherKeyAlias);
            }
            _item = new ClassEntity(_tmpId,_tmpClassName,_tmpTeacherName,_tmpTeacherGender,_tmpSchoolName,_tmpTeacherPhotoPath,_tmpTeacherKeyAlias);
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
  public Object getClassById(final long id, final Continuation<? super ClassEntity> $completion) {
    final String _sql = "SELECT * FROM classes WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<ClassEntity>() {
      @Override
      @Nullable
      public ClassEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClassName = CursorUtil.getColumnIndexOrThrow(_cursor, "className");
          final int _cursorIndexOfTeacherName = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherName");
          final int _cursorIndexOfTeacherGender = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherGender");
          final int _cursorIndexOfSchoolName = CursorUtil.getColumnIndexOrThrow(_cursor, "schoolName");
          final int _cursorIndexOfTeacherPhotoPath = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherPhotoPath");
          final int _cursorIndexOfTeacherKeyAlias = CursorUtil.getColumnIndexOrThrow(_cursor, "teacherKeyAlias");
          final ClassEntity _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpClassName;
            if (_cursor.isNull(_cursorIndexOfClassName)) {
              _tmpClassName = null;
            } else {
              _tmpClassName = _cursor.getString(_cursorIndexOfClassName);
            }
            final String _tmpTeacherName;
            if (_cursor.isNull(_cursorIndexOfTeacherName)) {
              _tmpTeacherName = null;
            } else {
              _tmpTeacherName = _cursor.getString(_cursorIndexOfTeacherName);
            }
            final String _tmpTeacherGender;
            if (_cursor.isNull(_cursorIndexOfTeacherGender)) {
              _tmpTeacherGender = null;
            } else {
              _tmpTeacherGender = _cursor.getString(_cursorIndexOfTeacherGender);
            }
            final String _tmpSchoolName;
            if (_cursor.isNull(_cursorIndexOfSchoolName)) {
              _tmpSchoolName = null;
            } else {
              _tmpSchoolName = _cursor.getString(_cursorIndexOfSchoolName);
            }
            final String _tmpTeacherPhotoPath;
            if (_cursor.isNull(_cursorIndexOfTeacherPhotoPath)) {
              _tmpTeacherPhotoPath = null;
            } else {
              _tmpTeacherPhotoPath = _cursor.getString(_cursorIndexOfTeacherPhotoPath);
            }
            final String _tmpTeacherKeyAlias;
            if (_cursor.isNull(_cursorIndexOfTeacherKeyAlias)) {
              _tmpTeacherKeyAlias = null;
            } else {
              _tmpTeacherKeyAlias = _cursor.getString(_cursorIndexOfTeacherKeyAlias);
            }
            _result = new ClassEntity(_tmpId,_tmpClassName,_tmpTeacherName,_tmpTeacherGender,_tmpSchoolName,_tmpTeacherPhotoPath,_tmpTeacherKeyAlias);
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
