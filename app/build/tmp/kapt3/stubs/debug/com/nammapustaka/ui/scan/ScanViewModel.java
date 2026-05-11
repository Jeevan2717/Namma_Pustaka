package com.nammapustaka.ui.scan;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0016J<\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006!"}, d2 = {"Lcom/nammapustaka/ui/scan/ScanViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "app", "Lcom/nammapustaka/NammaPustakaApp;", "students", "Landroidx/lifecycle/LiveData;", "", "Lcom/nammapustaka/data/entity/StudentEntity;", "getStudents", "()Landroidx/lifecycle/LiveData;", "activeForBook", "Lcom/nammapustaka/data/entity/BorrowTransactionEntity;", "bookId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bookByQr", "Lcom/nammapustaka/data/entity/BookEntity;", "qr", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "issue", "Lkotlinx/coroutines/Job;", "studentId", "teacherId", "issueDate", "", "dueDate", "done", "Lkotlin/Function0;", "", "app_debug"})
public final class ScanViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.NammaPustakaApp app = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.entity.StudentEntity>> students = null;
    
    public ScanViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.entity.StudentEntity>> getStudents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object bookByQr(@org.jetbrains.annotations.NotNull()
    java.lang.String qr, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BookEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object activeForBook(int bookId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.BorrowTransactionEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job issue(int bookId, int studentId, int teacherId, long issueDate, long dueDate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> done) {
        return null;
    }
}