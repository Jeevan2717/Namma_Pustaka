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
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.nammapustaka.data.entity.BookEntity;
import java.lang.Boolean;
import java.lang.Class;
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
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BookDao_Impl implements BookDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BookEntity> __insertionAdapterOfBookEntity;

  private final EntityDeletionOrUpdateAdapter<BookEntity> __deletionAdapterOfBookEntity;

  private final EntityDeletionOrUpdateAdapter<BookEntity> __updateAdapterOfBookEntity;

  public BookDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookEntity = new EntityInsertionAdapter<BookEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `book` (`id`,`title`,`author`,`category`,`coverImagePath`,`summaryKannada`,`totalPages`,`qrCode`,`isAvailable`,`addedDate`,`addedByTeacherId`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuthor());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getCoverImagePath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCoverImagePath());
        }
        if (entity.getSummaryKannada() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSummaryKannada());
        }
        statement.bindLong(7, entity.getTotalPages());
        if (entity.getQrCode() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getQrCode());
        }
        final int _tmp = entity.isAvailable() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getAddedDate());
        statement.bindLong(11, entity.getAddedByTeacherId());
      }
    };
    this.__deletionAdapterOfBookEntity = new EntityDeletionOrUpdateAdapter<BookEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `book` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookEntity entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfBookEntity = new EntityDeletionOrUpdateAdapter<BookEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `book` SET `id` = ?,`title` = ?,`author` = ?,`category` = ?,`coverImagePath` = ?,`summaryKannada` = ?,`totalPages` = ?,`qrCode` = ?,`isAvailable` = ?,`addedDate` = ?,`addedByTeacherId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BookEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getAuthor() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getAuthor());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getCategory());
        }
        if (entity.getCoverImagePath() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getCoverImagePath());
        }
        if (entity.getSummaryKannada() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSummaryKannada());
        }
        statement.bindLong(7, entity.getTotalPages());
        if (entity.getQrCode() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getQrCode());
        }
        final int _tmp = entity.isAvailable() ? 1 : 0;
        statement.bindLong(9, _tmp);
        statement.bindLong(10, entity.getAddedDate());
        statement.bindLong(11, entity.getAddedByTeacherId());
        statement.bindLong(12, entity.getId());
      }
    };
  }

  @Override
  public Object insert(final BookEntity book, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfBookEntity.insertAndReturnId(book);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final BookEntity book, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBookEntity.handle(book);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final BookEntity book, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBookEntity.handle(book);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BookEntity>> getAllBooks() {
    final String _sql = "SELECT * FROM book ORDER BY addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<List<BookEntity>>() {
      @Override
      @NonNull
      public List<BookEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final List<BookEntity> _result = new ArrayList<BookEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _item = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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
  public Flow<List<BookEntity>> searchBooks(final String query) {
    final String _sql = "SELECT * FROM book WHERE title LIKE '%' || ? || '%' OR author LIKE '%' || ? || '%' ORDER BY title";
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
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<List<BookEntity>>() {
      @Override
      @NonNull
      public List<BookEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final List<BookEntity> _result = new ArrayList<BookEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _item = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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
  public Flow<List<BookEntity>> byCategory(final String category) {
    final String _sql = "SELECT * FROM book WHERE category = ? ORDER BY title";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (category == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, category);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<List<BookEntity>>() {
      @Override
      @NonNull
      public List<BookEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final List<BookEntity> _result = new ArrayList<BookEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _item = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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
  public Flow<BookEntity> getBook(final int id) {
    final String _sql = "SELECT * FROM book WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<BookEntity>() {
      @Override
      @Nullable
      public BookEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final BookEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _result = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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
  public Object getBookOnce(final int id, final Continuation<? super BookEntity> $completion) {
    final String _sql = "SELECT * FROM book WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<BookEntity>() {
      @Override
      @Nullable
      public BookEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final BookEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _result = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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

  @Override
  public Object getBookByQrCode(final String qr,
      final Continuation<? super BookEntity> $completion) {
    final String _sql = "SELECT * FROM book WHERE qrCode = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (qr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, qr);
    }
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<BookEntity>() {
      @Override
      @Nullable
      public BookEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final BookEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            _result = new BookEntity(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId);
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

  @Override
  public Flow<Integer> countBooks() {
    final String _sql = "SELECT COUNT(*) FROM book";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<Integer>() {
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
  public Flow<Integer> countAvailable() {
    final String _sql = "SELECT COUNT(*) FROM book WHERE isAvailable = 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book"}, new Callable<Integer>() {
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
  public Flow<List<BookBorrowInfo>> getBookBorrowInfo() {
    final String _sql = "SELECT book.*, student.name AS studentName, borrow_transaction.issueDate AS issueDate, borrow_transaction.isOverdue AS isOverdue FROM book LEFT JOIN borrow_transaction ON borrow_transaction.bookId = book.id AND borrow_transaction.isReturned = 0 LEFT JOIN student ON student.id = borrow_transaction.studentId ORDER BY book.addedDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"book", "borrow_transaction",
        "student"}, new Callable<List<BookBorrowInfo>>() {
      @Override
      @NonNull
      public List<BookBorrowInfo> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCategory = CursorUtil.getColumnIndexOrThrow(_cursor, "category");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfSummaryKannada = CursorUtil.getColumnIndexOrThrow(_cursor, "summaryKannada");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfQrCode = CursorUtil.getColumnIndexOrThrow(_cursor, "qrCode");
          final int _cursorIndexOfIsAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "isAvailable");
          final int _cursorIndexOfAddedDate = CursorUtil.getColumnIndexOrThrow(_cursor, "addedDate");
          final int _cursorIndexOfAddedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "addedByTeacherId");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final List<BookBorrowInfo> _result = new ArrayList<BookBorrowInfo>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BookBorrowInfo _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCategory;
            if (_cursor.isNull(_cursorIndexOfCategory)) {
              _tmpCategory = null;
            } else {
              _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final String _tmpSummaryKannada;
            if (_cursor.isNull(_cursorIndexOfSummaryKannada)) {
              _tmpSummaryKannada = null;
            } else {
              _tmpSummaryKannada = _cursor.getString(_cursorIndexOfSummaryKannada);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpQrCode;
            if (_cursor.isNull(_cursorIndexOfQrCode)) {
              _tmpQrCode = null;
            } else {
              _tmpQrCode = _cursor.getString(_cursorIndexOfQrCode);
            }
            final boolean _tmpIsAvailable;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAvailable);
            _tmpIsAvailable = _tmp != 0;
            final long _tmpAddedDate;
            _tmpAddedDate = _cursor.getLong(_cursorIndexOfAddedDate);
            final int _tmpAddedByTeacherId;
            _tmpAddedByTeacherId = _cursor.getInt(_cursorIndexOfAddedByTeacherId);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
            }
            final Long _tmpIssueDate;
            if (_cursor.isNull(_cursorIndexOfIssueDate)) {
              _tmpIssueDate = null;
            } else {
              _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            }
            final Boolean _tmpIsOverdue;
            final Integer _tmp_1;
            if (_cursor.isNull(_cursorIndexOfIsOverdue)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            }
            _tmpIsOverdue = _tmp_1 == null ? null : _tmp_1 != 0;
            _item = new BookBorrowInfo(_tmpId,_tmpTitle,_tmpAuthor,_tmpCategory,_tmpCoverImagePath,_tmpSummaryKannada,_tmpTotalPages,_tmpQrCode,_tmpIsAvailable,_tmpAddedDate,_tmpAddedByTeacherId,_tmpStudentName,_tmpIssueDate,_tmpIsOverdue);
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
