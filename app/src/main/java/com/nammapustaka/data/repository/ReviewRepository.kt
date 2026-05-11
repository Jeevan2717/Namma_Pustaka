package com.nammapustaka.data.repository

import com.nammapustaka.data.dao.ReviewDao
import com.nammapustaka.data.entity.ReviewEntity

class ReviewRepository(private val dao: ReviewDao) {
    fun recentForBook(bookId: Int) = dao.recentForBook(bookId)
    fun averageRating(bookId: Int) = dao.averageRating(bookId)
    fun reviewCount(bookId: Int) = dao.reviewCount(bookId)
    fun countForStudent(studentId: Int) = dao.countForStudent(studentId)
    suspend fun insert(review: ReviewEntity) = dao.insert(review)
}
