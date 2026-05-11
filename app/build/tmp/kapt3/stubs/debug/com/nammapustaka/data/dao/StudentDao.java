package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rH\'J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2\u0006\u0010\u0010\u001a\u00020\u0005H\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\u0016\u001a\u00020\u0017H\'J\u0016\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/nammapustaka/data/dao/StudentDao;", "", "addPages", "", "studentId", "", "pages", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "student", "Lcom/nammapustaka/data/entity/StudentEntity;", "(Lcom/nammapustaka/data/entity/StudentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllStudents", "Lkotlinx/coroutines/flow/Flow;", "", "getStudent", "id", "getStudentOnce", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "search", "query", "", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface StudentDao {
    
    @androidx.room.Query(value = "SELECT * FROM student ORDER BY totalPagesRead DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.StudentEntity>> getAllStudents();
    
    @androidx.room.Query(value = "SELECT * FROM student WHERE name LIKE \'%\' || :query || \'%\' OR rollNumber LIKE \'%\' || :query || \'%\' ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.entity.StudentEntity>> search(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Query(value = "SELECT * FROM student WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.StudentEntity> getStudent(int id);
    
    @androidx.room.Query(value = "SELECT * FROM student WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getStudentOnce(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.StudentEntity> $completion);
    
    @androidx.room.Query(value = "UPDATE student SET totalPagesRead = totalPagesRead + :pages WHERE id = :studentId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addPages(int studentId, int pages, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.StudentEntity student, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}