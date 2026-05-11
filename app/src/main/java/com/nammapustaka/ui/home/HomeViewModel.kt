package com.nammapustaka.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.nammapustaka.NammaPustakaApp

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val books = app.bookRepository.bookBorrowInfo.asLiveData()
    val students = app.studentRepository.allStudents.asLiveData()
    val transactions = app.transactionRepository.details.asLiveData()
    val overdue = app.transactionRepository.overdueDetails.asLiveData()
}
