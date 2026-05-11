package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\b\u001a\u00020\u0006H\'J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0012"}, d2 = {"Lcom/nammapustaka/data/dao/ReviewDao;", "", "averageRating", "Lkotlinx/coroutines/flow/Flow;", "", "bookId", "", "countForStudent", "studentId", "insert", "", "review", "Lcom/nammapustaka/data/entity/ReviewEntity;", "(Lcom/nammapustaka/data/entity/ReviewEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recentForBook", "", "Lcom/nammapustaka/data/dao/ReviewDetail;", "reviewCount", "app_debug"})
@androidx.room.Dao()
public abstract interface ReviewDao {
    
    @androidx.room.Query(value = "SELECT review.*, student.name AS studentName, student.avatarPath AS avatarPath FROM review JOIN student ON student.id = review.studentId WHERE bookId = :bookId ORDER BY reviewDate DESC LIMIT 3")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.ReviewDetail>> recentForBook(int bookId);
    
    @androidx.room.Query(value = "SELECT AVG(starRating) FROM review WHERE bookId = :bookId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> averageRating(int bookId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM review WHERE bookId = :bookId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> reviewCount(int bookId);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM review WHERE studentId = :studentId")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> countForStudent(int studentId);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.ReviewEntity review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}