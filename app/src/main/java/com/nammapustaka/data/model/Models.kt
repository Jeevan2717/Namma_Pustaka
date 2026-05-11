package com.nammapustaka.data.model

data class Book(val id: Int, val title: String, val author: String, val category: String, val coverImagePath: String, val summaryKannada: String, val totalPages: Int, val qrCode: String, val isAvailable: Boolean, val addedDate: Long, val addedByTeacherId: Int)
data class Student(val id: Int, val name: String, val rollNumber: String, val classSection: String, val avatarPath: String, val totalPagesRead: Int)
data class BorrowTransaction(val id: Int, val bookId: Int, val studentId: Int, val issuedByTeacherId: Int, val issueDate: Long, val dueDate: Long, val returnDate: Long?, val isReturned: Boolean, val isOverdue: Boolean)
data class Review(val id: Int, val bookId: Int, val studentId: Int, val starRating: Int, val reviewText: String, val reviewDate: Long)
data class User(val id: Int, val fullName: String, val username: String, val passwordHash: String, val role: String, val linkedStudentId: Int?)
