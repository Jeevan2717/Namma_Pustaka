package com.nammapustaka.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u000fH\u00c6\u0003J\t\u0010/\u001a\u00020\u000fH\u00c6\u0003J\t\u00100\u001a\u00020\u000fH\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u000fH\u00c6\u0003J\t\u00103\u001a\u00020\u000fH\u00c6\u0003J\t\u00104\u001a\u00020\u000fH\u00c6\u0003J\t\u00105\u001a\u00020\u000fH\u00c6\u0003J\t\u00106\u001a\u00020\u0003H\u00c6\u0003J\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\bH\u00c6\u0003J\t\u0010:\u001a\u00020\bH\u00c6\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\bH\u00c6\u0003\u00a2\u0006\u0002\u0010\'J\t\u0010<\u001a\u00020\fH\u00c6\u0003J\t\u0010=\u001a\u00020\fH\u00c6\u0003J\u00ba\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u000f2\b\b\u0002\u0010\u0015\u001a\u00020\u000f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\f2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010B\u001a\u00020\u0003H\u00d6\u0001J\t\u0010C\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\t\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010#R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010\'R\u0011\u0010\u0014\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001c\u00a8\u0006D"}, d2 = {"Lcom/nammapustaka/data/dao/TransactionDetail;", "", "id", "", "bookId", "studentId", "issuedByTeacherId", "issueDate", "", "dueDate", "returnDate", "isReturned", "", "isOverdue", "bookTitle", "", "author", "coverImagePath", "totalPages", "studentName", "rollNumber", "classSection", "avatarPath", "(IIIIJJLjava/lang/Long;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Ljava/lang/String;", "getAvatarPath", "getBookId", "()I", "getBookTitle", "getClassSection", "getCoverImagePath", "getDueDate", "()J", "getId", "()Z", "getIssueDate", "getIssuedByTeacherId", "getReturnDate", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRollNumber", "getStudentId", "getStudentName", "getTotalPages", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IIIIJJLjava/lang/Long;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/nammapustaka/data/dao/TransactionDetail;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class TransactionDetail {
    private final int id = 0;
    private final int bookId = 0;
    private final int studentId = 0;
    private final int issuedByTeacherId = 0;
    private final long issueDate = 0L;
    private final long dueDate = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long returnDate = null;
    private final boolean isReturned = false;
    private final boolean isOverdue = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String bookTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String coverImagePath = null;
    private final int totalPages = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String studentName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rollNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String classSection = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatarPath = null;
    
    public TransactionDetail(int id, int bookId, int studentId, int issuedByTeacherId, long issueDate, long dueDate, @org.jetbrains.annotations.Nullable()
    java.lang.Long returnDate, boolean isReturned, boolean isOverdue, @org.jetbrains.annotations.NotNull()
    java.lang.String bookTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String coverImagePath, int totalPages, @org.jetbrains.annotations.NotNull()
    java.lang.String studentName, @org.jetbrains.annotations.NotNull()
    java.lang.String rollNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String classSection, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarPath) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int getBookId() {
        return 0;
    }
    
    public final int getStudentId() {
        return 0;
    }
    
    public final int getIssuedByTeacherId() {
        return 0;
    }
    
    public final long getIssueDate() {
        return 0L;
    }
    
    public final long getDueDate() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getReturnDate() {
        return null;
    }
    
    public final boolean isReturned() {
        return false;
    }
    
    public final boolean isOverdue() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBookTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCoverImagePath() {
        return null;
    }
    
    public final int getTotalPages() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStudentName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRollNumber() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getClassSection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatarPath() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.nammapustaka.data.dao.TransactionDetail copy(int id, int bookId, int studentId, int issuedByTeacherId, long issueDate, long dueDate, @org.jetbrains.annotations.Nullable()
    java.lang.Long returnDate, boolean isReturned, boolean isOverdue, @org.jetbrains.annotations.NotNull()
    java.lang.String bookTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String coverImagePath, int totalPages, @org.jetbrains.annotations.NotNull()
    java.lang.String studentName, @org.jetbrains.annotations.NotNull()
    java.lang.String rollNumber, @org.jetbrains.annotations.NotNull()
    java.lang.String classSection, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarPath) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}