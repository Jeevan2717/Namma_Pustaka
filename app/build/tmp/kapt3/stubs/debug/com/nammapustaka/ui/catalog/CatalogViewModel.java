package com.nammapustaka.ui.catalog;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\b2\u0006\u0010\u001c\u001a\u00020\u0010J\u001e\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/nammapustaka/ui/catalog/CatalogViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "app", "Lcom/nammapustaka/NammaPustakaApp;", "books", "Landroidx/lifecycle/LiveData;", "", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "getBooks", "()Landroidx/lifecycle/LiveData;", "activeForBook", "Lcom/nammapustaka/data/entity/BorrowTransactionEntity;", "id", "", "addBook", "Lkotlinx/coroutines/Job;", "book", "Lcom/nammapustaka/data/entity/BookEntity;", "done", "Lkotlin/Function0;", "", "bookOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reviews", "Lcom/nammapustaka/data/dao/ReviewDetail;", "bookId", "updateBook", "app_debug"})
public final class CatalogViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.NammaPustakaApp app = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> books = null;
    
    public CatalogViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> getBooks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nammapustaka.data.entity.BookEntity> book(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nammapustaka.data.entity.BorrowTransactionEntity> activeForBook(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.ReviewDetail>> reviews(int bookId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object bookOnce(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job addBook(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> done) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job updateBook(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.BookEntity book, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> done) {
        return null;
    }
}