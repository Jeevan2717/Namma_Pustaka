package com.nammapustaka.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00062\u0006\u0010\b\u001a\u00020\tJ\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/nammapustaka/data/repository/ReviewRepository;", "", "dao", "Lcom/nammapustaka/data/dao/ReviewDao;", "(Lcom/nammapustaka/data/dao/ReviewDao;)V", "averageRating", "Lkotlinx/coroutines/flow/Flow;", "", "bookId", "", "countForStudent", "studentId", "insert", "", "review", "Lcom/nammapustaka/data/entity/ReviewEntity;", "(Lcom/nammapustaka/data/entity/ReviewEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recentForBook", "", "Lcom/nammapustaka/data/dao/ReviewDetail;", "reviewCount", "app_debug"})
public final class ReviewRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.nammapustaka.data.dao.ReviewDao dao = null;
    
    public ReviewRepository(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.dao.ReviewDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.nammapustaka.data.dao.ReviewDetail>> recentForBook(int bookId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Double> averageRating(int bookId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> reviewCount(int bookId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> countForStudent(int studentId) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.ReviewEntity review, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
}