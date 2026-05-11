package com.nammapustaka.util

import android.content.Context

class SessionManager(context: Context) {
    private val prefs = context.getSharedPreferences("np_prefs", Context.MODE_PRIVATE)

    fun saveSession(userId: Int, role: String, fullName: String) {
        prefs.edit().putInt("userId", userId).putString("role", role).putString("fullName", fullName).putBoolean("loggedIn", true).apply()
    }

    fun getUserId(): Int = prefs.getInt("userId", 0)
    fun getUserRole(): String = prefs.getString("role", "student") ?: "student"
    fun getUserName(): String = prefs.getString("fullName", "") ?: ""
    fun isLoggedIn(): Boolean = prefs.getBoolean("loggedIn", false)
    fun clearSession() = prefs.edit().clear().apply()
}
