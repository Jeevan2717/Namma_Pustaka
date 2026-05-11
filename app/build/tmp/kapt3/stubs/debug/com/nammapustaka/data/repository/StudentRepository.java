package com.nammapustaka.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/nammapustaka/data/repository/StudentRepository;", "", "dao", "Lcom/nammapustaka/data/dao/StudentDao;", "(Lcom/nammapustaka/data/dao/StudentDao;)V", "allStudents", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/nammapustaka/data/entity/StudentEntity;", "getAllStudents", "()Lkotlinx/coroutines/flow/Flow;", "insert", "", "student", "(Lcom/nammapustaka/data/entity/StudentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "search", "query", "", "id", "", "studentOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "", "app_debug"})
public final class StudentRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.StudentDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.StudentEntity>> allStudents = null;
    
    public StudentRepository(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.StudentDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.StudentEntity>> getAllStudents() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.StudentEntity>> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.StudentEntity> student(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object studentOnce(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.StudentEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}