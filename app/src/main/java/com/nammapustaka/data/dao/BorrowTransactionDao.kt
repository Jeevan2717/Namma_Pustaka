package com.nammapustaka.data.dao

import androidx.room.*
import com.nammapustaka.data.entity.BorrowTransactionEntity
import kotlinx.coroutines.flow.Flow

data class TransactionDetail(
    val id: Int,
    val bookId: Int,
    val studentId: Int,
    val issuedByTeacherId: Int,
    val issueDate: Long,
    val dueDate: Long,
    val returnDate: Long?,
    val isReturned: Boolean,
    val isOverdue: Boolean,
    val bookTitle: String,
    val author: String,
    val coverImagePath: String,
    val totalPages: Int,
    val studentName: String,
    val rollNumber: String,
    val classSection: String,
    val avatarPath: String
)

@Dao
interface BorrowTransactionDao {
    @Query("SELECT * FROM borrow_transaction ORDER BY issueDate DESC")
    fun getAll(): Flow<List<BorrowTransactionEntity>>

    @Query("SELECT * FROM borrow_transaction WHERE bookId = :bookId AND isReturned = 0 LIMIT 1")
    fun activeForBook(bookId: Int): Flow<BorrowTransactionEntity?>

    @Query("SELECT * FROM borrow_transaction WHERE bookId = :bookId AND isReturned = 0 LIMIT 1")
    suspend fun activeForBookOnce(bookId: Int): BorrowTransactionEntity?

    @Query("SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId ORDER BY borrow_transaction.issueDate DESC")
    fun details(): Flow<List<TransactionDetail>>

    @Query("SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.studentId = :studentId ORDER BY borrow_transaction.issueDate DESC")
    fun detailsForStudent(studentId: Int): Flow<List<TransactionDetail>>

    @Query("SELECT borrow_transaction.*, book.title AS bookTitle, book.author AS author, book.coverImagePath AS coverImagePath, book.totalPages AS totalPages, student.name AS studentName, student.rollNumber AS rollNumber, student.classSection AS classSection, student.avatarPath AS avatarPath FROM borrow_transaction JOIN book ON book.id = borrow_transaction.bookId JOIN student ON student.id = borrow_transaction.studentId WHERE borrow_transaction.isReturned = 0 AND borrow_transaction.isOverdue = 1 ORDER BY borrow_transaction.dueDate ASC")
    fun overdueDetails(): Flow<List<TransactionDetail>>

    @Query("UPDATE borrow_transaction SET isOverdue = 1 WHERE isReturned = 0 AND dueDate < :now")
    suspend fun markOverdue(now: Long)

    @Insert suspend fun insert(transaction: BorrowTransactionEntity): Long
    @Update suspend fun update(transaction: BorrowTransactionEntity)
}
