package com.nammapustaka.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class StudentEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val rollNumber: String,
    val classSection: String,
    val avatarPath: String = "",
    val totalPagesRead: Int = 0
)
