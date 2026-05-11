package com.nammapustaka.data.db;

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
import com.nammapustaka.data.dao.BookDao;
import com.nammapustaka.data.dao.BookDao_Impl;
import com.nammapustaka.data.dao.BorrowTransactionDao;
import com.nammapustaka.data.dao.BorrowTransactionDao_Impl;
import com.nammapustaka.data.dao.ReviewDao;
import com.nammapustaka.data.dao.ReviewDao_Impl;
import com.nammapustaka.data.dao.StudentDao;
import com.nammapustaka.data.dao.StudentDao_Impl;
import com.nammapustaka.data.dao.UserDao;
import com.nammapustaka.data.dao.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile BookDao _bookDao;

  private volatile StudentDao _studentDao;

  private volatile BorrowTransactionDao _borrowTransactionDao;

  private volatile ReviewDao _reviewDao;

  private volatile UserDao _userDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `book` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `title` TEXT NOT NULL, `author` TEXT NOT NULL, `category` TEXT NOT NULL, `coverImagePath` TEXT NOT NULL, `summaryKannada` TEXT NOT NULL, `totalPages` INTEGER NOT NULL, `qrCode` TEXT NOT NULL, `isAvailable` INTEGER NOT NULL, `addedDate` INTEGER NOT NULL, `addedByTeacherId` INTEGER NOT NULL)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_book_qrCode` ON `book` (`qrCode`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `student` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `rollNumber` TEXT NOT NULL, `classSection` TEXT NOT NULL, `avatarPath` TEXT NOT NULL, `totalPagesRead` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `borrow_transaction` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bookId` INTEGER NOT NULL, `studentId` INTEGER NOT NULL, `issuedByTeacherId` INTEGER NOT NULL, `issueDate` INTEGER NOT NULL, `dueDate` INTEGER NOT NULL, `returnDate` INTEGER, `isReturned` INTEGER NOT NULL, `isOverdue` INTEGER NOT NULL, FOREIGN KEY(`bookId`) REFERENCES `book`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`studentId`) REFERENCES `student`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_borrow_transaction_bookId` ON `borrow_transaction` (`bookId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_borrow_transaction_studentId` ON `borrow_transaction` (`studentId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `review` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `bookId` INTEGER NOT NULL, `studentId` INTEGER NOT NULL, `starRating` INTEGER NOT NULL, `reviewText` TEXT NOT NULL, `reviewDate` INTEGER NOT NULL, FOREIGN KEY(`bookId`) REFERENCES `book`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`studentId`) REFERENCES `student`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_review_bookId` ON `review` (`bookId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_review_studentId` ON `review` (`studentId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `fullName` TEXT NOT NULL, `username` TEXT NOT NULL, `passwordHash` TEXT NOT NULL, `role` TEXT NOT NULL, `linkedStudentId` INTEGER)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_user_username` ON `user` (`username`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '276b91ce333d5c0afab2c7758126ddfa')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `book`");
        db.execSQL("DROP TABLE IF EXISTS `student`");
        db.execSQL("DROP TABLE IF EXISTS `borrow_transaction`");
        db.execSQL("DROP TABLE IF EXISTS `review`");
        db.execSQL("DROP TABLE IF EXISTS `user`");
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
        db.execSQL("PRAGMA foreign_keys = ON");
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
        final HashMap<String, TableInfo.Column> _columnsBook = new HashMap<String, TableInfo.Column>(11);
        _columnsBook.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("title", new TableInfo.Column("title", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("author", new TableInfo.Column("author", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("category", new TableInfo.Column("category", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("coverImagePath", new TableInfo.Column("coverImagePath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("summaryKannada", new TableInfo.Column("summaryKannada", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("totalPages", new TableInfo.Column("totalPages", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("qrCode", new TableInfo.Column("qrCode", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("isAvailable", new TableInfo.Column("isAvailable", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("addedDate", new TableInfo.Column("addedDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBook.put("addedByTeacherId", new TableInfo.Column("addedByTeacherId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBook = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBook = new HashSet<TableInfo.Index>(1);
        _indicesBook.add(new TableInfo.Index("index_book_qrCode", true, Arrays.asList("qrCode"), Arrays.asList("ASC")));
        final TableInfo _infoBook = new TableInfo("book", _columnsBook, _foreignKeysBook, _indicesBook);
        final TableInfo _existingBook = TableInfo.read(db, "book");
        if (!_infoBook.equals(_existingBook)) {
          return new RoomOpenHelper.ValidationResult(false, "book(com.nammapustaka.data.entity.BookEntity).\n"
                  + " Expected:\n" + _infoBook + "\n"
                  + " Found:\n" + _existingBook);
        }
        final HashMap<String, TableInfo.Column> _columnsStudent = new HashMap<String, TableInfo.Column>(6);
        _columnsStudent.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("rollNumber", new TableInfo.Column("rollNumber", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("classSection", new TableInfo.Column("classSection", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("avatarPath", new TableInfo.Column("avatarPath", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStudent.put("totalPagesRead", new TableInfo.Column("totalPagesRead", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStudent = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStudent = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStudent = new TableInfo("student", _columnsStudent, _foreignKeysStudent, _indicesStudent);
        final TableInfo _existingStudent = TableInfo.read(db, "student");
        if (!_infoStudent.equals(_existingStudent)) {
          return new RoomOpenHelper.ValidationResult(false, "student(com.nammapustaka.data.entity.StudentEntity).\n"
                  + " Expected:\n" + _infoStudent + "\n"
                  + " Found:\n" + _existingStudent);
        }
        final HashMap<String, TableInfo.Column> _columnsBorrowTransaction = new HashMap<String, TableInfo.Column>(9);
        _columnsBorrowTransaction.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("bookId", new TableInfo.Column("bookId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("issuedByTeacherId", new TableInfo.Column("issuedByTeacherId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("issueDate", new TableInfo.Column("issueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("dueDate", new TableInfo.Column("dueDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("returnDate", new TableInfo.Column("returnDate", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("isReturned", new TableInfo.Column("isReturned", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBorrowTransaction.put("isOverdue", new TableInfo.Column("isOverdue", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBorrowTransaction = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysBorrowTransaction.add(new TableInfo.ForeignKey("book", "CASCADE", "NO ACTION", Arrays.asList("bookId"), Arrays.asList("id")));
        _foreignKeysBorrowTransaction.add(new TableInfo.ForeignKey("student", "CASCADE", "NO ACTION", Arrays.asList("studentId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesBorrowTransaction = new HashSet<TableInfo.Index>(2);
        _indicesBorrowTransaction.add(new TableInfo.Index("index_borrow_transaction_bookId", false, Arrays.asList("bookId"), Arrays.asList("ASC")));
        _indicesBorrowTransaction.add(new TableInfo.Index("index_borrow_transaction_studentId", false, Arrays.asList("studentId"), Arrays.asList("ASC")));
        final TableInfo _infoBorrowTransaction = new TableInfo("borrow_transaction", _columnsBorrowTransaction, _foreignKeysBorrowTransaction, _indicesBorrowTransaction);
        final TableInfo _existingBorrowTransaction = TableInfo.read(db, "borrow_transaction");
        if (!_infoBorrowTransaction.equals(_existingBorrowTransaction)) {
          return new RoomOpenHelper.ValidationResult(false, "borrow_transaction(com.nammapustaka.data.entity.BorrowTransactionEntity).\n"
                  + " Expected:\n" + _infoBorrowTransaction + "\n"
                  + " Found:\n" + _existingBorrowTransaction);
        }
        final HashMap<String, TableInfo.Column> _columnsReview = new HashMap<String, TableInfo.Column>(6);
        _columnsReview.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReview.put("bookId", new TableInfo.Column("bookId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReview.put("studentId", new TableInfo.Column("studentId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReview.put("starRating", new TableInfo.Column("starRating", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReview.put("reviewText", new TableInfo.Column("reviewText", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsReview.put("reviewDate", new TableInfo.Column("reviewDate", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysReview = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysReview.add(new TableInfo.ForeignKey("book", "CASCADE", "NO ACTION", Arrays.asList("bookId"), Arrays.asList("id")));
        _foreignKeysReview.add(new TableInfo.ForeignKey("student", "CASCADE", "NO ACTION", Arrays.asList("studentId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesReview = new HashSet<TableInfo.Index>(2);
        _indicesReview.add(new TableInfo.Index("index_review_bookId", false, Arrays.asList("bookId"), Arrays.asList("ASC")));
        _indicesReview.add(new TableInfo.Index("index_review_studentId", false, Arrays.asList("studentId"), Arrays.asList("ASC")));
        final TableInfo _infoReview = new TableInfo("review", _columnsReview, _foreignKeysReview, _indicesReview);
        final TableInfo _existingReview = TableInfo.read(db, "review");
        if (!_infoReview.equals(_existingReview)) {
          return new RoomOpenHelper.ValidationResult(false, "review(com.nammapustaka.data.entity.ReviewEntity).\n"
                  + " Expected:\n" + _infoReview + "\n"
                  + " Found:\n" + _existingReview);
        }
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(6);
        _columnsUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("fullName", new TableInfo.Column("fullName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("username", new TableInfo.Column("username", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("passwordHash", new TableInfo.Column("passwordHash", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("role", new TableInfo.Column("role", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("linkedStudentId", new TableInfo.Column("linkedStudentId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(1);
        _indicesUser.add(new TableInfo.Index("index_user_username", true, Arrays.asList("username"), Arrays.asList("ASC")));
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(db, "user");
        if (!_infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.nammapustaka.data.entity.UserEntity).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "276b91ce333d5c0afab2c7758126ddfa", "7f3fa2d894a1dc66f2b0990c6095e482");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "book","student","borrow_transaction","review","user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `book`");
      _db.execSQL("DELETE FROM `student`");
      _db.execSQL("DELETE FROM `borrow_transaction`");
      _db.execSQL("DELETE FROM `review`");
      _db.execSQL("DELETE FROM `user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
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
    _typeConvertersMap.put(BookDao.class, BookDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StudentDao.class, StudentDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(BorrowTransactionDao.class, BorrowTransactionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(ReviewDao.class, ReviewDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
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
  public BookDao bookDao() {
    if (_bookDao != null) {
      return _bookDao;
    } else {
      synchronized(this) {
        if(_bookDao == null) {
          _bookDao = new BookDao_Impl(this);
        }
        return _bookDao;
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
  public BorrowTransactionDao borrowTransactionDao() {
    if (_borrowTransactionDao != null) {
      return _borrowTransactionDao;
    } else {
      synchronized(this) {
        if(_borrowTransactionDao == null) {
          _borrowTransactionDao = new BorrowTransactionDao_Impl(this);
        }
        return _borrowTransactionDao;
      }
    }
  }

  @Override
  public ReviewDao reviewDao() {
    if (_reviewDao != null) {
      return _reviewDao;
    } else {
      synchronized(this) {
        if(_reviewDao == null) {
          _reviewDao = new ReviewDao_Impl(this);
        }
        return _reviewDao;
      }
    }
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }
}
