package com.nammapustaka.ui.leaderboard

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import com.nammapustaka.NammaPustakaApp

class LeaderboardViewModel(application: Application) : AndroidViewModel(application) {
    val students = (application as NammaPustakaApp).studentRepository.allStudents.asLiveData()
}
