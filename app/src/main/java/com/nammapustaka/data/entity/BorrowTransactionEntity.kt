package com.nammapustaka.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "borrow_transaction",
    foreignKeys = [
        ForeignKey(entity = BookEntity::class, parentColumns = ["id"], childColumns = ["bookId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = StudentEntity::class, parentColumns = ["id"], childColumns = ["studentId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("bookId"), Index("studentId")]
)
data class BorrowTransactionEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bookId: Int,
    val studentId: Int,
    val issuedByTeacherId: Int,
    val issueDate: Long,
    val dueDate: Long,
    val returnDate: Long? = null,
    val isReturned: Boolean = false,
    val isOverdue: Boolean = false
)
