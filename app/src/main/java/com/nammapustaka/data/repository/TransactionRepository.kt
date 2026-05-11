package com.nammapustaka.data.repository

import com.nammapustaka.data.dao.BookDao
import com.nammapustaka.data.dao.BorrowTransactionDao
import com.nammapustaka.data.dao.StudentDao
import com.nammapustaka.data.entity.BorrowTransactionEntity

class TransactionRepository(
    private val dao: BorrowTransactionDao,
    private val bookDao: BookDao,
    private val studentDao: StudentDao
) {
    val all = dao.getAll()
    val details = dao.details()
    val overdueDetails = dao.overdueDetails()
    fun detailsForStudent(studentId: Int) = dao.detailsForStudent(studentId)
    fun activeForBook(bookId: Int) = dao.activeForBook(bookId)
    suspend fun activeForBookOnce(bookId: Int) = dao.activeForBookOnce(bookId)

    suspend fun issue(bookId: Int, studentId: Int, teacherId: Int, issueDate: Long, dueDate: Long) {
        dao.insert(BorrowTransactionEntity(bookId = bookId, studentId = studentId, issuedByTeacherId = teacherId, issueDate = issueDate, dueDate = dueDate))
        bookDao.getBookOnce(bookId)?.let { bookDao.update(it.copy(isAvailable = false)) }
    }

    suspend fun returnBook(transaction: BorrowTransactionEntity, pages: Int) {
        dao.update(transaction.copy(isReturned = true, returnDate = System.currentTimeMillis(), isOverdue = false))
        bookDao.getBookOnce(transaction.bookId)?.let { bookDao.update(it.copy(isAvailable = true)) }
        studentDao.addPages(transaction.studentId, pages)
    }
}
