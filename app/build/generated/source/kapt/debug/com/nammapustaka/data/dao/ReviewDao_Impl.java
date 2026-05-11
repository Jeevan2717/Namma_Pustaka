package com.nammapustaka.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammapustaka.data.entity.ReviewEntity;
import java.lang.Class;
import java.lang.Double;
import java.lang.Exception;
import java.lang.Integer;
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
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class ReviewDao_Impl implements ReviewDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ReviewEntity> __insertionAdapterOfReviewEntity;

  public ReviewDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReviewEntity = new EntityInsertionAdapter<ReviewEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `review` (`id`,`bookId`,`studentId`,`starRating`,`reviewText`,`reviewDate`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final ReviewEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getBookId());
        statement.bindLong(3, entity.getStudentId());
        statement.bindLong(4, entity.getStarRating());
        if (entity.getReviewText() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getReviewText());
        }
        statement.bindLong(6, entity.getReviewDate());
      }
    };
  }

  @Override
  public Object insert(final ReviewEntity review, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfReviewEntity.insertAndReturnId(review);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<ReviewDetail>> recentForBook(final int bookId) {
    final String _sql = "SELECT review.*, student.name AS studentName, student.avatarPath AS avatarPath FROM review JOIN student ON student.id = review.studentId WHERE bookId = ? ORDER BY reviewDate DESC LIMIT 3";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"review",
        "student"}, new Callable<List<ReviewDetail>>() {
      @Override
      @NonNull
      public List<ReviewDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfStarRating = CursorUtil.getColumnIndexOrThrow(_cursor, "starRating");
          final int _cursorIndexOfReviewText = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewText");
          final int _cursorIndexOfReviewDate = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewDate");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final List<ReviewDetail> _result = new ArrayList<ReviewDetail>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final ReviewDetail _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpStarRating;
            _tmpStarRating = _cursor.getInt(_cursorIndexOfStarRating);
            final String _tmpReviewText;
            if (_cursor.isNull(_cursorIndexOfReviewText)) {
              _tmpReviewText = null;
            } else {
              _tmpReviewText = _cursor.getString(_cursorIndexOfReviewText);
            }
            final long _tmpReviewDate;
            _tmpReviewDate = _cursor.getLong(_cursorIndexOfReviewDate);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final String _tmpAvatarPath;
            if (_cursor.isNull(_cursorIndexOfAvatarPath)) {
              _tmpAvatarPath = null;
            } else {
              _tmpAvatarPath = _cursor.getString(_cursorIndexOfAvatarPath);
            }
            _item = new ReviewDetail(_tmpId,_tmpBookId,_tmpStudentId,_tmpStarRating,_tmpReviewText,_tmpReviewDate,_tmpStudentName,_tmpAvatarPath);
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
  public Flow<Double> averageRating(final int bookId) {
    final String _sql = "SELECT AVG(starRating) FROM review WHERE bookId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"review"}, new Callable<Double>() {
      @Override
      @Nullable
      public Double call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Double _result;
          if (_cursor.moveToFirst()) {
            final Double _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getDouble(0);
            }
            _result = _tmp;
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
  public Flow<Integer> reviewCount(final int bookId) {
    final String _sql = "SELECT COUNT(*) FROM review WHERE bookId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"review"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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
  public Flow<Integer> countForStudent(final int studentId) {
    final String _sql = "SELECT COUNT(*) FROM review WHERE studentId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"review"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
