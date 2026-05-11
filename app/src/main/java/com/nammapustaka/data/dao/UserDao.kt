package com.nammapustaka.data.dao

import androidx.room.*
import com.nammapustaka.data.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE username = :username LIMIT 1")
    suspend fun findByUsername(username: String): UserEntity?

    @Query("SELECT * FROM user WHERE id = :id LIMIT 1")
    fun getUser(id: Int): Flow<UserEntity?>

    @Query("SELECT COUNT(*) FROM user WHERE username = :username")
    suspend fun usernameCount(username: String): Int

    @Insert suspend fun insert(user: UserEntity): Long
}
