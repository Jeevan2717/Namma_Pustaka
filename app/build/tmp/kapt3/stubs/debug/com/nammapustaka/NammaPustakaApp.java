package com.nammapustaka;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/nammapustaka/NammaPustakaApp;", "Landroid/app/Application;", "()V", "bookRepository", "Lcom/nammapustaka/data/repository/BookRepository;", "getBookRepository", "()Lcom/nammapustaka/data/repository/BookRepository;", "bookRepository$delegate", "Lkotlin/Lazy;", "database", "Lcom/nammapustaka/data/db/AppDatabase;", "getDatabase", "()Lcom/nammapustaka/data/db/AppDatabase;", "database$delegate", "reviewRepository", "Lcom/nammapustaka/data/repository/ReviewRepository;", "getReviewRepository", "()Lcom/nammapustaka/data/repository/ReviewRepository;", "reviewRepository$delegate", "studentRepository", "Lcom/nammapustaka/data/repository/StudentRepository;", "getStudentRepository", "()Lcom/nammapustaka/data/repository/StudentRepository;", "studentRepository$delegate", "transactionRepository", "Lcom/nammapustaka/data/repository/TransactionRepository;", "getTransactionRepository", "()Lcom/nammapustaka/data/repository/TransactionRepository;", "transactionRepository$delegate", "userRepository", "Lcom/nammapustaka/data/repository/UserRepository;", "getUserRepository", "()Lcom/nammapustaka/data/repository/UserRepository;", "userRepository$delegate", "onCreate", "", "app_debug"})
public final class NammaPustakaApp extends android.app.Application {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy database$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy bookRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy studentRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy transactionRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy reviewRepository$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy userRepository$delegate = null;
    
    public NammaPustakaApp() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.db.AppDatabase getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.repository.BookRepository getBookRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.repository.StudentRepository getStudentRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.repository.TransactionRepository getTransactionRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.repository.ReviewRepository getReviewRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.repository.UserRepository getUserRepository() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
}