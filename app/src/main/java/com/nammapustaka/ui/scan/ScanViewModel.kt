package com.nammapustaka.ui.scan

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nammapustaka.NammaPustakaApp
import kotlinx.coroutines.launch

class ScanViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val students = app.studentRepository.allStudents.asLiveData()
    suspend fun bookByQr(qr: String) = app.bookRepository.byQr(qr)
    suspend fun activeForBook(bookId: Int) = app.transactionRepository.activeForBookOnce(bookId)
    fun issue(bookId: Int, studentId: Int, teacherId: Int, issueDate: Long, dueDate: Long, done: () -> Unit) = viewModelScope.launch {
        app.transactionRepository.issue(bookId, studentId, teacherId, issueDate, dueDate); done()
    }
}
