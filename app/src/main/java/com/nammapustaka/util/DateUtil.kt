package com.nammapustaka.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtil {
    private const val DAY = 86_400_000L
    fun format(ts: Long): String = SimpleDateFormat("dd MMM yyyy", Locale.getDefault()).format(Date(ts))
    fun dueDate(daysFromNow: Int = 14): Long = System.currentTimeMillis() + daysFromNow * DAY
    fun isOverdue(dueDate: Long): Boolean = dueDate < System.currentTimeMillis()
    fun daysOverdue(dueDate: Long): Int = ((System.currentTimeMillis() - dueDate) / DAY).toInt().coerceAtLeast(0)
}
