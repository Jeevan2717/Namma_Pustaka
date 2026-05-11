package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/nammapustaka/data/dao/UserDao;", "", "findByUsername", "Lcom/nammapustaka/data/entity/UserEntity;", "username", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lkotlinx/coroutines/flow/Flow;", "id", "", "insert", "", "user", "(Lcom/nammapustaka/data/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "usernameCount", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT * FROM user WHERE username = :username LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object findByUsername(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.nammapustaka.data.entity.UserEntity> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM user WHERE id = :id LIMIT 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.nammapustaka.data.entity.UserEntity> getUser(int id);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM user WHERE username = :username")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object usernameCount(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.nammapustaka.data.entity.UserEntity user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
}