package com.nammapustaka.ui.profile

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.nammapustaka.NammaPustakaApp

class ProfileViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    fun user(id: Int) = app.userRepository.user(id).asLiveData()
    fun student(id: Int) = app.studentRepository.student(id).asLiveData()
    fun studentTransactions(id: Int) = app.transactionRepository.detailsForStudent(id).asLiveData()
    val allTransactions = app.transactionRepository.details.asLiveData()
    val students = app.studentRepository.allStudents.asLiveData()
    val books = app.bookRepository.bookBorrowInfo.asLiveData()
}
