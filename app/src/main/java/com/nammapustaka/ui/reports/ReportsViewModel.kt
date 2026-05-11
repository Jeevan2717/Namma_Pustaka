package com.nammapustaka.ui.reports

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.nammapustaka.NammaPustakaApp

class ReportsViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val overdue = app.transactionRepository.overdueDetails.asLiveData()
    val history = app.transactionRepository.details.asLiveData()
    val books = app.bookRepository.bookBorrowInfo.asLiveData()
}
