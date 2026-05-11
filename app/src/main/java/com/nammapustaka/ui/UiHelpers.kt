package com.nammapustaka.ui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.nammapustaka.R
import com.nammapustaka.util.SessionManager

fun Fragment.session() = SessionManager(requireContext())

fun Fragment.requireTeacherOrHome(): Boolean {
    if (session().getUserRole() == "teacher") return true
    Snackbar.make(requireView(), "Teacher access only", Snackbar.LENGTH_SHORT).show()
    findNavController().navigate(R.id.homeFragment)
    return false
}

fun TextView.pill(bg: Int, fg: Int) {
    setTextColor(fg)
    background = GradientDrawable().apply { setColor(bg); cornerRadius = 40f }
}

fun View.goneIf(condition: Boolean) { visibility = if (condition) View.GONE else View.VISIBLE }

fun String.categoryKannada(): String = when (this) {
    "Story" -> "ಕಥೆ"
    "Science" -> "ವಿಜ್ಞಾನ"
    "History" -> "ಇತಿಹಾಸ"
    else -> this
}

fun TextView.availability(available: Boolean, kannada: Boolean = false) {
    text = if (available) if (kannada) "ಲಭ್ಯವಿದೆ" else "Available" else if (kannada) "ಎರವಲು ಪಡೆಯಲಾಗಿದೆ" else "Borrowed"
    val bg = Color.parseColor(if (available) "#E1F5EE" else "#FAEEDA")
    val fg = Color.parseColor(if (available) "#085041" else "#633806")
    pill(bg, fg)
}
