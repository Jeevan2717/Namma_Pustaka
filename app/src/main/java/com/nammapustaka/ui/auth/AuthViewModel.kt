package com.nammapustaka.ui.auth

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.data.entity.UserEntity
import com.nammapustaka.util.HashUtil

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val students = app.studentRepository.allStudents.asLiveData()
    suspend fun login(username: String, password: String, role: String) = app.userRepository.login(username, password, role)
    suspend fun usernameAvailable(username: String) = app.userRepository.usernameAvailable(username)
    suspend fun register(fullName: String, username: String, password: String, role: String, linkedStudentId: Int?) =
        app.userRepository.register(UserEntity(fullName = fullName, username = username, passwordHash = HashUtil.sha256(password), role = role, linkedStudentId = linkedStudentId))
}
