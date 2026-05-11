package com.nammapustaka.data.repository

import com.nammapustaka.data.dao.BookDao
import com.nammapustaka.data.entity.BookEntity

class BookRepository(private val dao: BookDao) {
    val allBooks = dao.getAllBooks()
    val bookBorrowInfo = dao.getBookBorrowInfo()
    val totalBooks = dao.countBooks()
    val availableBooks = dao.countAvailable()
    fun search(query: String) = dao.searchBooks(query)
    fun category(category: String) = dao.byCategory(category)
    fun book(id: Int) = dao.getBook(id)
    suspend fun bookOnce(id: Int) = dao.getBookOnce(id)
    suspend fun byQr(qr: String) = dao.getBookByQrCode(qr)
    suspend fun insert(book: BookEntity) = dao.insert(book)
    suspend fun update(book: BookEntity) = dao.update(book)
    suspend fun delete(book: BookEntity) = dao.delete(book)
}
