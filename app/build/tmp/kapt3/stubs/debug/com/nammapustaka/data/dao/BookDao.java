package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0018\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\u0011\u001a\u00020\tH\'J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\u0003H\'J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u001c\u001a\u00020\u0007H\'J\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u001e"}, d2 = {"Lcom/nammapustaka/data/dao/BookDao;", "", "byCategory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammapustaka/data/entity/BookEntity;", "category", "", "countAvailable", "", "countBooks", "delete", "", "book", "(Lcom/nammapustaka/data/entity/BookEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBooks", "getBook", "id", "getBookBorrowInfo", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "getBookByQrCode", "qr", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBookOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "searchBooks", "query", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface BookDao {
    
    @androidx.room.Query(value = "SELECT * FROM book ORDER BY addedDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> getAllBooks();
    
    @androidx.room.Query(value = "SELECT * FROM book WHERE title LIKE \'%\' || :query || \'%\' OR author LIKE \'%\' || :query || \'%\' ORDER BY title")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> searchBooks(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM book WHERE category = :category ORDER BY title")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> byCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM book WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.BookEntity> getBook(int id);
    
    @androidx.room.Query(value = "SELECT * FROM book WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookOnce(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM book WHERE qrCode = :qr")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBookByQrCode(@org.jetbrains.annotations.NotNull()
    java.lang.String qr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM book")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> countBooks();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM book WHERE isAvailable = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> countAvailable();
    
    @androidx.room.Query(value = "SELECT book.*, student.name AS studentName, borrow_transaction.issueDate AS issueDate, borrow_transaction.isOverdue AS isOverdue FROM book LEFT JOIN borrow_transaction ON borrow_transaction.bookId = book.id AND borrow_transaction.isReturned = 0 LEFT JOIN student ON student.id = borrow_transaction.studentId ORDER BY book.addedDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> getBookBorrowInfo();
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}