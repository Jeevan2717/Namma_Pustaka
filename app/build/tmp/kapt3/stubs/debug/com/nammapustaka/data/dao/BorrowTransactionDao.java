package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003H\'J\u001c\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u00032\u0006\u0010\r\u001a\u00020\u0006H\'J\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\n0\u0003H\'J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\u0003H\'J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/nammapustaka/data/dao/BorrowTransactionDao;", "", "activeForBook", "Lkotlinx/coroutines/flow/Flow;", "Lcom/nammapustaka/data/entity/BorrowTransactionEntity;", "bookId", "", "activeForBookOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "details", "", "Lcom/nammapustaka/data/dao/TransactionDetail;", "detailsForStudent", "studentId", "getAll", "insert", "", "transaction", "(Lcom/nammapustaka/data/entity/BorrowTransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markOverdue", "", "now", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "overdueDetails", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface BorrowTransactionDao {
    
    @androidx.room.Query(value = "SELECT * FROM borrow_transaction ORDER BY issueDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BorrowTransactionEntity>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM borrow_transaction WHERE bookId = :bookId AND isReturned = 0 LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.BorrowTransactionEntity> activeForBook(int bookId);
    
    @androidx.room.Query(value = "SELECT * FROM borrow_transaction WHERE bookId = :bookId AND isReturned = 0 LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object activeForBookOnce(int bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BorrowTransactionEntity> $completion);
    
    @androidx.room.Query(value = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId ORDER BY borrow_transaction.issueDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> details();
    
    @androidx.room.Query(value = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.studentId = :studentId ORDER BY borrow_transaction.issueDate DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> detailsForStudent(int studentId);
    
    @androidx.room.Query(value = "SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.isReturned = 0 AND borrow_transaction.isOverdue = 1 ORDER BY borrow_transaction.dueDate ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> overdueDetails();
    
    @androidx.room.Query(value = "UPDATE borrow_transaction SET isOverdue = 1 WHERE isReturned = 0 AND dueDate < :now")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object markOverdue(long now, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BorrowTransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BorrowTransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}