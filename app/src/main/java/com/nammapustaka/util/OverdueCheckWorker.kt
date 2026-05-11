package com.nammapustaka.util

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.nammapustaka.data.db.AppDatabase

class OverdueCheckWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        AppDatabase.getInstance(applicationContext).borrowTransactionDao().markOverdue(System.currentTimeMillis())
        return Result.success()
    }
}
