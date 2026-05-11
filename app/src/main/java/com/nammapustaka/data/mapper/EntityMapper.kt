package com.nammapustaka.data.mapper

import com.nammapustaka.data.entity.*
import com.nammapustaka.data.model.*

fun BookEntity.toModel() = Book(id, title, author, category, coverImagePath, summaryKannada, totalPages, qrCode, isAvailable, addedDate, addedByTeacherId)
fun StudentEntity.toModel() = Student(id, name, rollNumber, classSection, avatarPath, totalPagesRead)
fun BorrowTransactionEntity.toModel() = BorrowTransaction(id, bookId, studentId, issuedByTeacherId, issueDate, dueDate, returnDate, isReturned, isOverdue)
fun ReviewEntity.toModel() = Review(id, bookId, studentId, starRating, reviewText, reviewDate)
fun UserEntity.toModel() = User(id, fullName, username, passwordHash, role, linkedStudentId)
