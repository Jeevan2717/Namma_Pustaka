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
import com.nammapustaka.data.entity.BorrowTransactionEntity;
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
public final class BorrowTransactionDao_Impl implements BorrowTransactionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BorrowTransactionEntity> __insertionAdapterOfBorrowTransactionEntity;

  private final EntityDeletionOrUpdateAdapter<BorrowTransactionEntity> __updateAdapterOfBorrowTransactionEntity;

  private final SharedSQLiteStatement __preparedStmtOfMarkOverdue;

  public BorrowTransactionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBorrowTransactionEntity = new EntityInsertionAdapter<BorrowTransactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `borrow_transaction` (`id`,`bookId`,`studentId`,`issuedByTeacherId`,`issueDate`,`dueDate`,`returnDate`,`isReturned`,`isOverdue`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BorrowTransactionEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getBookId());
        statement.bindLong(3, entity.getStudentId());
        statement.bindLong(4, entity.getIssuedByTeacherId());
        statement.bindLong(5, entity.getIssueDate());
        statement.bindLong(6, entity.getDueDate());
        if (entity.getReturnDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getReturnDate());
        }
        final int _tmp = entity.isReturned() ? 1 : 0;
        statement.bindLong(8, _tmp);
        final int _tmp_1 = entity.isOverdue() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
      }
    };
    this.__updateAdapterOfBorrowTransactionEntity = new EntityDeletionOrUpdateAdapter<BorrowTransactionEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `borrow_transaction` SET `id` = ?,`bookId` = ?,`studentId` = ?,`issuedByTeacherId` = ?,`issueDate` = ?,`dueDate` = ?,`returnDate` = ?,`isReturned` = ?,`isOverdue` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final BorrowTransactionEntity entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getBookId());
        statement.bindLong(3, entity.getStudentId());
        statement.bindLong(4, entity.getIssuedByTeacherId());
        statement.bindLong(5, entity.getIssueDate());
        statement.bindLong(6, entity.getDueDate());
        if (entity.getReturnDate() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getReturnDate());
        }
        final int _tmp = entity.isReturned() ? 1 : 0;
        statement.bindLong(8, _tmp);
        final int _tmp_1 = entity.isOverdue() ? 1 : 0;
        statement.bindLong(9, _tmp_1);
        statement.bindLong(10, entity.getId());
      }
    };
    this.__preparedStmtOfMarkOverdue = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE borrow_transaction SET isOverdue = 1 WHERE isReturned = 0 AND dueDate < ?";
        return _query;
      }
    };
  }

  @Override
  public Object insert(final BorrowTransactionEntity transaction,
      final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfBorrowTransactionEntity.insertAndReturnId(transaction);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final BorrowTransactionEntity transaction,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBorrowTransactionEntity.handle(transaction);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object markOverdue(final long now, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarkOverdue.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, now);
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
          __preparedStmtOfMarkOverdue.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<BorrowTransactionEntity>> getAll() {
    final String _sql = "SELECT * FROM borrow_transaction ORDER BY issueDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"borrow_transaction"}, new Callable<List<BorrowTransactionEntity>>() {
      @Override
      @NonNull
      public List<BorrowTransactionEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final List<BorrowTransactionEntity> _result = new ArrayList<BorrowTransactionEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final BorrowTransactionEntity _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            _item = new BorrowTransactionEntity(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue);
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
  public Flow<BorrowTransactionEntity> activeForBook(final int bookId) {
    final String _sql = "SELECT * FROM borrow_transaction WHERE bookId = ? AND isReturned = 0 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"borrow_transaction"}, new Callable<BorrowTransactionEntity>() {
      @Override
      @Nullable
      public BorrowTransactionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final BorrowTransactionEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            _result = new BorrowTransactionEntity(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue);
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
  public Object activeForBookOnce(final int bookId,
      final Continuation<? super BorrowTransactionEntity> $completion) {
    final String _sql = "SELECT * FROM borrow_transaction WHERE bookId = ? AND isReturned = 0 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, bookId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<BorrowTransactionEntity>() {
      @Override
      @Nullable
      public BorrowTransactionEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final BorrowTransactionEntity _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            _result = new BorrowTransactionEntity(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue);
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
  public Flow<List<TransactionDetail>> details() {
    final String _sql = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId ORDER BY borrow_transaction.issueDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"borrow_transaction", "book",
        "student"}, new Callable<List<TransactionDetail>>() {
      @Override
      @NonNull
      public List<TransactionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final int _cursorIndexOfBookTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "bookTitle");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final List<TransactionDetail> _result = new ArrayList<TransactionDetail>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionDetail _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            final String _tmpBookTitle;
            if (_cursor.isNull(_cursorIndexOfBookTitle)) {
              _tmpBookTitle = null;
            } else {
              _tmpBookTitle = _cursor.getString(_cursorIndexOfBookTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
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
            _item = new TransactionDetail(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue,_tmpBookTitle,_tmpAuthor,_tmpCoverImagePath,_tmpTotalPages,_tmpStudentName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath);
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
  public Flow<List<TransactionDetail>> detailsForStudent(final int studentId) {
    final String _sql = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.studentId = ? ORDER BY borrow_transaction.issueDate DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, studentId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"borrow_transaction", "book",
        "student"}, new Callable<List<TransactionDetail>>() {
      @Override
      @NonNull
      public List<TransactionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final int _cursorIndexOfBookTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "bookTitle");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final List<TransactionDetail> _result = new ArrayList<TransactionDetail>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionDetail _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            final String _tmpBookTitle;
            if (_cursor.isNull(_cursorIndexOfBookTitle)) {
              _tmpBookTitle = null;
            } else {
              _tmpBookTitle = _cursor.getString(_cursorIndexOfBookTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
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
            _item = new TransactionDetail(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue,_tmpBookTitle,_tmpAuthor,_tmpCoverImagePath,_tmpTotalPages,_tmpStudentName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath);
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
  public Flow<List<TransactionDetail>> overdueDetails() {
    final String _sql = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.isReturned = 0 AND borrow_transaction.isOverdue = 1 ORDER BY borrow_transaction.dueDate ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"borrow_transaction", "book",
        "student"}, new Callable<List<TransactionDetail>>() {
      @Override
      @NonNull
      public List<TransactionDetail> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfBookId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookId");
          final int _cursorIndexOfStudentId = CursorUtil.getColumnIndexOrThrow(_cursor, "studentId");
          final int _cursorIndexOfIssuedByTeacherId = CursorUtil.getColumnIndexOrThrow(_cursor, "issuedByTeacherId");
          final int _cursorIndexOfIssueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "issueDate");
          final int _cursorIndexOfDueDate = CursorUtil.getColumnIndexOrThrow(_cursor, "dueDate");
          final int _cursorIndexOfReturnDate = CursorUtil.getColumnIndexOrThrow(_cursor, "returnDate");
          final int _cursorIndexOfIsReturned = CursorUtil.getColumnIndexOrThrow(_cursor, "isReturned");
          final int _cursorIndexOfIsOverdue = CursorUtil.getColumnIndexOrThrow(_cursor, "isOverdue");
          final int _cursorIndexOfBookTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "bookTitle");
          final int _cursorIndexOfAuthor = CursorUtil.getColumnIndexOrThrow(_cursor, "author");
          final int _cursorIndexOfCoverImagePath = CursorUtil.getColumnIndexOrThrow(_cursor, "coverImagePath");
          final int _cursorIndexOfTotalPages = CursorUtil.getColumnIndexOrThrow(_cursor, "totalPages");
          final int _cursorIndexOfStudentName = CursorUtil.getColumnIndexOrThrow(_cursor, "studentName");
          final int _cursorIndexOfRollNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "rollNumber");
          final int _cursorIndexOfClassSection = CursorUtil.getColumnIndexOrThrow(_cursor, "classSection");
          final int _cursorIndexOfAvatarPath = CursorUtil.getColumnIndexOrThrow(_cursor, "avatarPath");
          final List<TransactionDetail> _result = new ArrayList<TransactionDetail>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final TransactionDetail _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpBookId;
            _tmpBookId = _cursor.getInt(_cursorIndexOfBookId);
            final int _tmpStudentId;
            _tmpStudentId = _cursor.getInt(_cursorIndexOfStudentId);
            final int _tmpIssuedByTeacherId;
            _tmpIssuedByTeacherId = _cursor.getInt(_cursorIndexOfIssuedByTeacherId);
            final long _tmpIssueDate;
            _tmpIssueDate = _cursor.getLong(_cursorIndexOfIssueDate);
            final long _tmpDueDate;
            _tmpDueDate = _cursor.getLong(_cursorIndexOfDueDate);
            final Long _tmpReturnDate;
            if (_cursor.isNull(_cursorIndexOfReturnDate)) {
              _tmpReturnDate = null;
            } else {
              _tmpReturnDate = _cursor.getLong(_cursorIndexOfReturnDate);
            }
            final boolean _tmpIsReturned;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsReturned);
            _tmpIsReturned = _tmp != 0;
            final boolean _tmpIsOverdue;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsOverdue);
            _tmpIsOverdue = _tmp_1 != 0;
            final String _tmpBookTitle;
            if (_cursor.isNull(_cursorIndexOfBookTitle)) {
              _tmpBookTitle = null;
            } else {
              _tmpBookTitle = _cursor.getString(_cursorIndexOfBookTitle);
            }
            final String _tmpAuthor;
            if (_cursor.isNull(_cursorIndexOfAuthor)) {
              _tmpAuthor = null;
            } else {
              _tmpAuthor = _cursor.getString(_cursorIndexOfAuthor);
            }
            final String _tmpCoverImagePath;
            if (_cursor.isNull(_cursorIndexOfCoverImagePath)) {
              _tmpCoverImagePath = null;
            } else {
              _tmpCoverImagePath = _cursor.getString(_cursorIndexOfCoverImagePath);
            }
            final int _tmpTotalPages;
            _tmpTotalPages = _cursor.getInt(_cursorIndexOfTotalPages);
            final String _tmpStudentName;
            if (_cursor.isNull(_cursorIndexOfStudentName)) {
              _tmpStudentName = null;
            } else {
              _tmpStudentName = _cursor.getString(_cursorIndexOfStudentName);
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
            _item = new TransactionDetail(_tmpId,_tmpBookId,_tmpStudentId,_tmpIssuedByTeacherId,_tmpIssueDate,_tmpDueDate,_tmpReturnDate,_tmpIsReturned,_tmpIsOverdue,_tmpBookTitle,_tmpAuthor,_tmpCoverImagePath,_tmpTotalPages,_tmpStudentName,_tmpRollNumber,_tmpClassSection,_tmpAvatarPath);
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
