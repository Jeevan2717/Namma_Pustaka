package com.nammapustaka.data.dao

import androidx.room.*
import com.nammapustaka.data.entity.ReviewEntity
import kotlinx.coroutines.flow.Flow

data class ReviewDetail(val id: Int, val bookId: Int, val studentId: Int, val starRating: Int, val reviewText: String, val reviewDate: Long, val studentName: String, val avatarPath: String)

@Dao
interface ReviewDao {
    @Query("SELECT review.*, student.name AS studentName, student.avatarPath AS avatarPath FROM review JOIN student ON student.id = review.studentId WHERE bookId = :bookId ORDER BY reviewDate DESC LIMIT 3")
    fun recentForBook(bookId: Int): Flow<List<ReviewDetail>>

    @Query("SELECT AVG(starRating) FROM review WHERE bookId = :bookId")
    fun averageRating(bookId: Int): Flow<Double?>

    @Query("SELECT COUNT(*) FROM review WHERE bookId = :bookId")
    fun reviewCount(bookId: Int): Flow<Int>

    @Query("SELECT COUNT(*) FROM review WHERE studentId = :studentId")
    fun countForStudent(studentId: Int): Flow<Int>

    @Insert suspend fun insert(review: ReviewEntity): Long
}
