package com.nammapustaka.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0014\u001a\u00020\fJ\u0018\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001b\u001a\u00020\u0019J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\"\u001a\u00020\u0019J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u001eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n\u00a8\u0006$"}, d2 = {"Lcom/nammapustaka/data/repository/BookRepository;", "", "dao", "Lcom/nammapustaka/data/dao/BookDao;", "(Lcom/nammapustaka/data/dao/BookDao;)V", "allBooks", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammapustaka/data/entity/BookEntity;", "getAllBooks", "()Lkotlinx/coroutines/flow/Flow;", "availableBooks", "", "getAvailableBooks", "bookBorrowInfo", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "getBookBorrowInfo", "totalBooks", "getTotalBooks", "book", "id", "bookOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byQr", "qr", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "category", "delete", "", "(Lcom/nammapustaka/data/entity/BookEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "search", "query", "update", "app_debug"})
public final class BookRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.BookDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> allBooks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> bookBorrowInfo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> totalBooks = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.lang.Integer> availableBooks = null;
    
    public BookRepository(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.BookDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> getAllBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> getBookBorrowInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getAvailableBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.BookEntity>> category(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.BookEntity> book(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object bookOnce(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object byQr(@org.jetbrains.annotations.NotNull()
    java.lang.String qr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}