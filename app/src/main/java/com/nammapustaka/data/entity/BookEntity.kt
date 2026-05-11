package com.nammapustaka.data.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "book", indices = [Index(value = ["qrCode"], unique = true)])
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val author: String,
    val category: String,
    val coverImagePath: String,
    val summaryKannada: String,
    val totalPages: Int,
    val qrCode: String,
    val isAvailable: Boolean = true,
    val addedDate: Long,
    val addedByTeacherId: Int
)
