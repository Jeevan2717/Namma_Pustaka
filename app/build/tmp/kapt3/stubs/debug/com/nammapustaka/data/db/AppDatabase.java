package com.nammapustaka.data.db;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&\u00a8\u0006\u000e"}, d2 = {"Lcom/nammapustaka/data/db/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "bookDao", "Lcom/nammapustaka/data/dao/BookDao;", "borrowTransactionDao", "Lcom/nammapustaka/data/dao/BorrowTransactionDao;", "reviewDao", "Lcom/nammapustaka/data/dao/ReviewDao;", "studentDao", "Lcom/nammapustaka/data/dao/StudentDao;", "userDao", "Lcom/nammapustaka/data/dao/UserDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.nammapustaka.data.entity.BookEntity.class, com.nammapustaka.data.entity.StudentEntity.class, com.nammapustaka.data.entity.BorrowTransactionEntity.class, com.nammapustaka.data.entity.ReviewEntity.class, com.nammapustaka.data.entity.UserEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.nammapustaka.data.db.AppDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.nammapustaka.data.db.AppDatabase.Companion Companion = null;
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammapustaka.data.dao.BookDao bookDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammapustaka.data.dao.StudentDao studentDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammapustaka.data.dao.BorrowTransactionDao borrowTransactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammapustaka.data.dao.ReviewDao reviewDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.nammapustaka.data.dao.UserDao userDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J=\u0010\u0005\u001a\u00020\u00062.\u0010\u0007\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\b\"\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH\u0002\u00a2\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJX\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/nammapustaka/data/db/AppDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/nammapustaka/data/db/AppDatabase;", "cv", "Landroid/content/ContentValues;", "pairs", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)Landroid/content/ContentValues;", "getInstance", "context", "Landroid/content/Context;", "seedBook", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "id", "", "title", "author", "category", "summary", "pages", "qr", "available", "", "added", "", "seedCallback", "Landroidx/room/RoomDatabase$Callback;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.nammapustaka.data.db.AppDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final androidx.room.RoomDatabase.Callback seedCallback() {
            return null;
        }
        
        private final void seedBook(androidx.sqlite.db.SupportSQLiteDatabase db, int id, java.lang.String title, java.lang.String author, java.lang.String category, java.lang.String summary, int pages, java.lang.String qr, boolean available, long added) {
        }
        
        private final android.content.ContentValues cv(kotlin.Pair<java.lang.String, ? extends java.lang.Object>... pairs) {
            return null;
        }
    }
}