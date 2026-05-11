package com.nammapustaka.data.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "review",
    foreignKeys = [
        ForeignKey(entity = BookEntity::class, parentColumns = ["id"], childColumns = ["bookId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = StudentEntity::class, parentColumns = ["id"], childColumns = ["studentId"], onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("bookId"), Index("studentId")]
)
data class ReviewEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val bookId: Int,
    val studentId: Int,
    val starRating: Int,
    val reviewText: String,
    val reviewDate: Long
)
