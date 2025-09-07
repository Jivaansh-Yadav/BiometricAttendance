package com.jivaansh.biometricattendance.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.jivaansh.biometricattendance.data.dao.AttendanceDao;
import com.jivaansh.biometricattendance.data.dao.AttendanceDao_Impl;
import com.jivaansh.biometricattendance.data.dao.ClassDao;
import com.jivaansh.biometricattendance.data.dao.ClassDao_Impl;
import com.jivaansh.biometricattendance.data.dao.HolidayDao;
import com.jivaansh.biometricattendance.data.dao.HolidayDao_Impl;
import com.jivaansh.biometricattendance.data.dao.StudentDao;
import com.jivaansh.biometricattendance.data.dao.StudentDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ClassDao _classDao;

  private volatile StudentDao _studentDao;

  private volatile AttendanceDao _attendanceDao;

  private volatile HolidayDao _holidayDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `classes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `className` TEXT NOT NULL, `teacherName` TEXT NOT NULL, `teacherGender` TEXT, `schoolName` TEXT, `teacherPhotoPath` TEXT, `teacherKeyAlias` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `students` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `classId` INTEGER NOT NULL, `studentName` TEXT NOT NULL, `studentGender` TEXT, `studentPhotoPath` TEXT, `studentKeyAlias` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `attendance` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `classId` INTEGER NOT NULL, `studentId` INTEGER NOT NULL, `dateISO` TEXT NOT NULL, `present` INTEGER NOT NULL, `timestamp` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `holidays` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `classId` INTEGER NOT NULL, `dateISO` TEXT NOT NULL, `holidayName` TEXT NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'fcd4427f0f2318c933d1e63558681f84')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `classes`");
        db.execSQL("DROP TABLE IF EXISTS `students`");
        db.execSQL("DROP TABLE IF EXISTS `attendance`");
        db.execSQL("DROP TABLE IF EXISTS `holidays`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsClasses = new HashMap<String, TableInfo.Column>(7);
        _columnsClasses.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("className", new TableInfo.Column("className", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherName", new TableInfo.Column("teacherName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherGender", new TableInfo.Column("teacherGender", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("schoolName", new TableInfo.Column("schoolName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherPhotoPath", new TableInfo.Column("teacherPhotoPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsClasses.put("teacherKeyAlias", new TableInfo.Column("teacherKeyAlias", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysClasses = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesClasses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoClasses = new TableInfo("classes", _columnsClasses, _foreignKeysClasses, _indicesClasses);
        final TableInfo _existingClasses = TableInfo.read(db, "classes");
        if (!_infoClasses.equals(_existingClasses)) {
          return new RoomOpenHelper.ValidationResult(false, "classes(com.jivaansh.biometricattendance.data.entities.ClassEntity).\n"
                  + " Expected:\n" + _infoClasses + "\n"
                  + " Found:\n" + _existingClasses);
        }
        final HashMap<String, TableInfo.Column> _columnsStudents = new HashMap<String, TableInfo.Column>(6);
        _columnsStudents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("studentName", new TableInfo.Column("studentName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("studentGender", new TableInfo.Column("studentGender", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("studentPhotoPath", new TableInfo.Column("studentPhotoPath", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudents.put("studentKeyAlias", new TableInfo.Column("studentKeyAlias", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudents = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudents = new TableInfo("students", _columnsStudents, _foreignKeysStudents, _indicesStudents);
        final TableInfo _existingStudents = TableInfo.read(db, "students");
        if (!_infoStudents.equals(_existingStudents)) {
          return new RoomOpenHelper.ValidationResult(false, "students(com.jivaansh.biometricattendance.data.entities.StudentEntity).\n"
                  + " Expected:\n" + _infoStudents + "\n"
                  + " Found:\n" + _existingStudents);
        }
        final HashMap<String, TableInfo.Column> _columnsAttendance = new HashMap<String, TableInfo.Column>(6);
        _columnsAttendance.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("dateISO", new TableInfo.Column("dateISO", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("present", new TableInfo.Column("present", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAttendance.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAttendance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAttendance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAttendance = new TableInfo("attendance", _columnsAttendance, _foreignKeysAttendance, _indicesAttendance);
        final TableInfo _existingAttendance = TableInfo.read(db, "attendance");
        if (!_infoAttendance.equals(_existingAttendance)) {
          return new RoomOpenHelper.ValidationResult(false, "attendance(com.jivaansh.biometricattendance.data.entities.AttendanceEntity).\n"
                  + " Expected:\n" + _infoAttendance + "\n"
                  + " Found:\n" + _existingAttendance);
        }
        final HashMap<String, TableInfo.Column> _columnsHolidays = new HashMap<String, TableInfo.Column>(4);
        _columnsHolidays.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHolidays.put("classId", new TableInfo.Column("classId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHolidays.put("dateISO", new TableInfo.Column("dateISO", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsHolidays.put("holidayName", new TableInfo.Column("holidayName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysHolidays = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesHolidays = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoHolidays = new TableInfo("holidays", _columnsHolidays, _foreignKeysHolidays, _indicesHolidays);
        final TableInfo _existingHolidays = TableInfo.read(db, "holidays");
        if (!_infoHolidays.equals(_existingHolidays)) {
          return new RoomOpenHelper.ValidationResult(false, "holidays(com.jivaansh.biometricattendance.data.entities.HolidayEntity).\n"
                  + " Expected:\n" + _infoHolidays + "\n"
                  + " Found:\n" + _existingHolidays);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "fcd4427f0f2318c933d1e63558681f84", "08b6a661b4ad1a0d5915acca9aff8704");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "classes","students","attendance","holidays");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `classes`");
      _db.execSQL("DELETE FROM `students`");
      _db.execSQL("DELETE FROM `attendance`");
      _db.execSQL("DELETE FROM `holidays`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(ClassDao.class, ClassDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StudentDao.class, StudentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AttendanceDao.class, AttendanceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(HolidayDao.class, HolidayDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public ClassDao classDao() {
    if (_classDao != null) {
      return _classDao;
    } else {
      synchronized(this) {
        if(_classDao == null) {
          _classDao = new ClassDao_Impl(this);
        }
        return _classDao;
      }
    }
  }

  @Override
  public StudentDao studentDao() {
    if (_studentDao != null) {
      return _studentDao;
    } else {
      synchronized(this) {
        if(_studentDao == null) {
          _studentDao = new StudentDao_Impl(this);
        }
        return _studentDao;
      }
    }
  }

  @Override
  public AttendanceDao attendanceDao() {
    if (_attendanceDao != null) {
      return _attendanceDao;
    } else {
      synchronized(this) {
        if(_attendanceDao == null) {
          _attendanceDao = new AttendanceDao_Impl(this);
        }
        return _attendanceDao;
      }
    }
  }

  @Override
  public HolidayDao holidayDao() {
    if (_holidayDao != null) {
      return _holidayDao;
    } else {
      synchronized(this) {
        if(_holidayDao == null) {
          _holidayDao = new HolidayDao_Impl(this);
        }
        return _holidayDao;
      }
    }
  }
}
