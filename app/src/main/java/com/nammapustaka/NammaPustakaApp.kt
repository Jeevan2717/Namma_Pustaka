package com.nammapustaka

import android.app.Application
import com.nammapustaka.data.db.AppDatabase
import com.nammapustaka.data.repository.*

class NammaPustakaApp : Application() {
    val database by lazy { AppDatabase.getInstance(this) }
    val bookRepository by lazy { BookRepository(database.bookDao()) }
    val studentRepository by lazy { StudentRepository(database.studentDao()) }
    val transactionRepository by lazy { TransactionRepository(database.borrowTransactionDao(), database.bookDao(), database.studentDao()) }
    val reviewRepository by lazy { ReviewRepository(database.reviewDao()) }
    val userRepository by lazy { UserRepository(database.userDao()) }

    override fun onCreate() {
        super.onCreate()
    }
}
