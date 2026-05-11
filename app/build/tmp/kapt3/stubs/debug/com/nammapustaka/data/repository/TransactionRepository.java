package com.nammapustaka.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n2\u0006\u0010\u001a\u001a\u00020\u0016J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0086@\u00a2\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0016H\u0086@\u00a2\u0006\u0002\u0010%R\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000b0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/nammapustaka/data/repository/TransactionRepository;", "", "dao", "Lcom/nammapustaka/data/dao/BorrowTransactionDao;", "bookDao", "Lcom/nammapustaka/data/dao/BookDao;", "studentDao", "Lcom/nammapustaka/data/dao/StudentDao;", "(Lcom/nammapustaka/data/dao/BorrowTransactionDao;Lcom/nammapustaka/data/dao/BookDao;Lcom/nammapustaka/data/dao/StudentDao;)V", "all", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammapustaka/data/entity/BorrowTransactionEntity;", "getAll", "()Lkotlinx/coroutines/flow/Flow;", "details", "Lcom/nammapustaka/data/dao/TransactionDetail;", "getDetails", "overdueDetails", "getOverdueDetails", "activeForBook", "bookId", "", "activeForBookOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detailsForStudent", "studentId", "issue", "", "teacherId", "issueDate", "", "dueDate", "(IIIJJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "returnBook", "transaction", "pages", "(Lcom/nammapustaka/data/entity/BorrowTransactionEntity;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class TransactionRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.BorrowTransactionDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.BookDao bookDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.StudentDao studentDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BorrowTransactionEntity>> all = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> details = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> overdueDetails = null;
    
    public TransactionRepository(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.BorrowTransactionDao dao, @org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.BookDao bookDao, @org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.StudentDao studentDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BorrowTransactionEntity>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> getDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> getOverdueDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> detailsForStudent(int studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.BorrowTransactionEntity> activeForBook(int bookId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object activeForBookOnce(int bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BorrowTransactionEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object issue(int bookId, int studentId, int teacherId, long issueDate, long dueDate, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object returnBook(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BorrowTransactionEntity transaction, int pages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}