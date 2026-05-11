package com.nammapustaka.ui.catalog

import android.app.Application
import androidx.lifecycle.*
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.data.entity.BookEntity
import kotlinx.coroutines.launch

class CatalogViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val books = app.bookRepository.bookBorrowInfo.asLiveData()
    fun book(id: Int) = app.bookRepository.book(id).asLiveData()
    fun activeForBook(id: Int) = app.transactionRepository.activeForBook(id).asLiveData()
    fun reviews(bookId: Int) = app.reviewRepository.recentForBook(bookId).asLiveData()
    suspend fun bookOnce(id: Int) = app.bookRepository.bookOnce(id)
    fun addBook(book: BookEntity, done: () -> Unit) = viewModelScope.launch { app.bookRepository.insert(book); done() }
    fun updateBook(book: BookEntity, done: () -> Unit = {}) = viewModelScope.launch { app.bookRepository.update(book); done() }
}
