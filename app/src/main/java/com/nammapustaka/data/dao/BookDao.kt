package com.nammapustaka.data.dao

import androidx.room.*
import com.nammapustaka.data.entity.BookEntity
import kotlinx.coroutines.flow.Flow

data class BookBorrowInfo(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    val coverImagePath: String,
    val summaryKannada: String,
    val totalPages: Int,
    val qrCode: String,
    val isAvailable: Boolean,
    val addedDate: Long,
    val addedByTeacherId: Int,
    val studentName: String?,
    val issueDate: Long?,
    val isOverdue: Boolean?
)

@Dao
interface BookDao {
    @Query("SELECT * FROM book ORDER BY addedDate DESC")
    fun getAllBooks(): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE title LIKE '%' || :query || '%' OR author LIKE '%' || :query || '%' ORDER BY title")
    fun searchBooks(query: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE category = :category ORDER BY title")
    fun byCategory(category: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM book WHERE id = :id")
    fun getBook(id: Int): Flow<BookEntity?>

    @Query("SELECT * FROM book WHERE id = :id")
    suspend fun getBookOnce(id: Int): BookEntity?

    @Query("SELECT * FROM book WHERE qrCode = :qr")
    suspend fun getBookByQrCode(qr: String): BookEntity?

    @Query("SELECT COUNT(*) FROM book")
    fun countBooks(): Flow<Int>

    @Query("SELECT COUNT(*) FROM book WHERE isAvailable = 1")
    fun countAvailable(): Flow<Int>

    @Query("SELECT book.*, student.name AS studentName, borrow_transaction.issueDate AS issueDate, borrow_transaction.isOverdue AS isOverdue FROM book LEFT JOIN borrow_transaction ON borrow_transaction.bookId = book.id AND borrow_transaction.isReturned = 0 LEFT JOIN student ON student.id = borrow_transaction.studentId ORDER BY book.addedDate DESC")
    fun getBookBorrowInfo(): Flow<List<BookBorrowInfo>>

    @Insert suspend fun insert(book: BookEntity): Long
    @Update suspend fun update(book: BookEntity)
    @Delete suspend fun delete(book: BookEntity)
}
