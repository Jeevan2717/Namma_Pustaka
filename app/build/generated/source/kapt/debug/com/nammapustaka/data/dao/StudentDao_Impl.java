package com.nammapustaka.data.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammapustaka.data.entity.StudentEntity;
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
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StudentDao_Impl implements StudentDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StudentEntity> __insertionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __deletionAdapterOfStudentEntity;

  private final EntityDeletionOrUpdateAdapter<StudentEntity> __updateAdapterOfStudentEntity;

  private final SharedSQLiteStatement __preparedStmtOfAddPages;

  public StudentDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudentEntity = new EntityInsertionAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `student` (`id`,`name`,`rollNumber`,`classSection`,`avatarPath`,`totalPagesRead`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getRollNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getRollNumber());
        }
        if (entity.getClassSection() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getClassSection());
        }
        if (entity.getAvatarPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAvatarPath());
        }
        statement.bindLong(6, entity.getTotalPagesRead());
      }
    };
    this.__deletionAdapterOfStudentEntity = new EntityDeletionOrUpdateAdapter<StudentEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `student` WHERE `id` = ?";
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
        return "UPDATE OR ABORT `student` SET `id` = ?,`name` = ?,`rollNumber` = ?,`classSection` = ?,`avatarPath` = ?,`totalPagesRead` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudentEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getName());
        }
        if (entity.getRollNumber() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getRollNumber());
        }
        if (entity.getClassSection() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getClassSection());
        }
        if (entity.getAvatarPath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getAvatarPath());
        }
        statement.bindLong(6, entity.getTotalPagesRead());
        statement.bindLong(7, entity.getId());
      }
    };
    this.__preparedStmtOfAddPages = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE student SET totalPagesRead = totalPagesRead + ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final StudentEntity student, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfStudentEntity.insertAndReturnId(student);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final StudentEntity student, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfStudentEntity.handle(student);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final StudentEntity student, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfStudentEntity.handle(student);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object addPages(final int studentId, final int pages,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfAddPages.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, pages);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, studentId);
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
          __preparedStmtOfAddPages.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<StudentEntity>> getAllStudents() {
    final String _sql = "SELECT * FROM student ORDER BY totalPagesRead DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student"}, new Callable<List<StudentEntity>>() {
      @Override
      @NonNull
      public List<StudentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final int _cursorIndexOfTotalPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPagesRead");
          final List<StudentEntity> _result = new ArrayList<StudentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRollNumber;
            if (_cursor.isNull(_cursorIndexOfRollNumber)) {
              _tmpRollNumber = null;
            } else {
              _tmpRollNumber = _cursor.getString(_cursorIndexOfRollNumber);
            }
            final String _tmpClassSection;
            if (_cursor.isNull(_cursorIndexOfClassSection)) {
              _tmpClassSection = null;
            } else {
              _tmpClassSection = _cursor.getString(_cursorIndexOfClassSection);
            }
            final String _tmpAvatarPath;
            if (_cursor.isNull(_cursorIndexOfAvatarPath)) {
              _tmpAvatarPath = null;
            } else {
              _tmpAvatarPath = _cursor.getString(_cursorIndexOfAvatarPath);
            }
            final int _tmpTotalPagesRead;
            _tmpTotalPagesRead = _cursor.getInt(_cursorIndexOfTotalPagesRead);
            _item = new StudentEntity(_tmpId,_tmpName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath,_tmpTotalPagesRead);
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
  public Flow<List<StudentEntity>> search(final String query) {
    final String _sql = "SELECT * FROM student WHERE name LIKE '%' || ? || '%' OR rollNumber LIKE '%' || ? || '%' ORDER BY name";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student"}, new Callable<List<StudentEntity>>() {
      @Override
      @NonNull
      public List<StudentEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final int _cursorIndexOfTotalPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPagesRead");
          final List<StudentEntity> _result = new ArrayList<StudentEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudentEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRollNumber;
            if (_cursor.isNull(_cursorIndexOfRollNumber)) {
              _tmpRollNumber = null;
            } else {
              _tmpRollNumber = _cursor.getString(_cursorIndexOfRollNumber);
            }
            final String _tmpClassSection;
            if (_cursor.isNull(_cursorIndexOfClassSection)) {
              _tmpClassSection = null;
            } else {
              _tmpClassSection = _cursor.getString(_cursorIndexOfClassSection);
            }
            final String _tmpAvatarPath;
            if (_cursor.isNull(_cursorIndexOfAvatarPath)) {
              _tmpAvatarPath = null;
            } else {
              _tmpAvatarPath = _cursor.getString(_cursorIndexOfAvatarPath);
            }
            final int _tmpTotalPagesRead;
            _tmpTotalPagesRead = _cursor.getInt(_cursorIndexOfTotalPagesRead);
            _item = new StudentEntity(_tmpId,_tmpName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath,_tmpTotalPagesRead);
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
  public Flow<StudentEntity> getStudent(final int id) {
    final String _sql = "SELECT * FROM student WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"student"}, new Callable<StudentEntity>() {
      @Override
      @Nullable
      public StudentEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final int _cursorIndexOfTotalPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPagesRead");
          final StudentEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRollNumber;
            if (_cursor.isNull(_cursorIndexOfRollNumber)) {
              _tmpRollNumber = null;
            } else {
              _tmpRollNumber = _cursor.getString(_cursorIndexOfRollNumber);
            }
            final String _tmpClassSection;
            if (_cursor.isNull(_cursorIndexOfClassSection)) {
              _tmpClassSection = null;
            } else {
              _tmpClassSection = _cursor.getString(_cursorIndexOfClassSection);
            }
            final String _tmpAvatarPath;
            if (_cursor.isNull(_cursorIndexOfAvatarPath)) {
              _tmpAvatarPath = null;
            } else {
              _tmpAvatarPath = _cursor.getString(_cursorIndexOfAvatarPath);
            }
            final int _tmpTotalPagesRead;
            _tmpTotalPagesRead = _cursor.getInt(_cursorIndexOfTotalPagesRead);
            _result = new StudentEntity(_tmpId,_tmpName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath,_tmpTotalPagesRead);
          } else {
            _result = null;
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
  public Object getStudentOnce(final int id,
      final Continuation<? super StudentEntity> $completion) {
    final String _sql = "SELECT * FROM student WHERE id = ?";
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
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final int _cursorIndexOfTotalPagesRead = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPagesRead");
          final StudentEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpName;
            if (_cursor.isNull(_cursorIndexOfName)) {
              _tmpName = null;
            } else {
              _tmpName = _cursor.getString(_cursorIndexOfName);
            }
            final String _tmpRollNumber;
            if (_cursor.isNull(_cursorIndexOfRollNumber)) {
              _tmpRollNumber = null;
            } else {
              _tmpRollNumber = _cursor.getString(_cursorIndexOfRollNumber);
            }
            final String _tmpClassSection;
            if (_cursor.isNull(_cursorIndexOfClassSection)) {
              _tmpClassSection = null;
            } else {
              _tmpClassSection = _cursor.getString(_cursorIndexOfClassSection);
            }
            final String _tmpAvatarPath;
            if (_cursor.isNull(_cursorIndexOfAvatarPath)) {
              _tmpAvatarPath = null;
            } else {
              _tmpAvatarPath = _cursor.getString(_cursorIndexOfAvatarPath);
            }
            final int _tmpTotalPagesRead;
            _tmpTotalPagesRead = _cursor.getInt(_cursorIndexOfTotalPagesRead);
            _result = new StudentEntity(_tmpId,_tmpName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath,_tmpTotalPagesRead);
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
