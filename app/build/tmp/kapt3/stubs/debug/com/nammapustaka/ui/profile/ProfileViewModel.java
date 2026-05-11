package com.nammapustaka.ui.profile;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00062\u0006\u0010\u0014\u001a\u00020\u0015R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/nammapustaka/ui/profile/ProfileViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allTransactions", "Landroidx/lifecycle/LiveData;", "", "Lcom/nammapustaka/data/dao/TransactionDetail;", "getAllTransactions", "()Landroidx/lifecycle/LiveData;", "app", "Lcom/nammapustaka/NammaPustakaApp;", "books", "Lcom/nammapustaka/data/dao/BookBorrowInfo;", "getBooks", "students", "Lcom/nammapustaka/data/entity/StudentEntity;", "getStudents", "student", "id", "", "studentTransactions", "user", "Lcom/nammapustaka/data/entity/UserEntity;", "app_debug"})
public final class ProfileViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.NammaPustakaApp app = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> allTransactions = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.entity.StudentEntity>> students = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> books = null;
    
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nammapustaka.data.entity.UserEntity> user(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.nammapustaka.data.entity.StudentEntity> student(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> studentTransactions(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.TransactionDetail>> getAllTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.entity.StudentEntity>> getStudents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.nammapustaka.data.dao.BookBorrowInfo>> getBooks() {
        return null;
    }
}