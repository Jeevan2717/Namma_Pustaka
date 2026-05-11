package com.nammapustaka.data.repository

import com.nammapustaka.data.entity.UserEntity
import com.nammapustaka.data.dao.UserDao
import com.nammapustaka.util.HashUtil

class UserRepository(private val dao: UserDao) {
    suspend fun login(username: String, password: String, role: String): UserEntity? {
        val user = dao.findByUsername(username) ?: return null
        return if (user.role == role && HashUtil.verify(password, user.passwordHash)) user else null
    }

    suspend fun usernameAvailable(username: String): Boolean = dao.usernameCount(username) == 0
    suspend fun register(user: UserEntity) = dao.insert(user)
    fun user(id: Int) = dao.getUser(id)
}
