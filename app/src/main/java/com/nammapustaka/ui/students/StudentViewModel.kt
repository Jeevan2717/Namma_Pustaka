package com.nammapustaka.ui.students

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.nammapustaka.NammaPustakaApp
import com.nammapustaka.data.entity.StudentEntity
import kotlinx.coroutines.launch

class StudentViewModel(application: Application) : AndroidViewModel(application) {
    private val app = application as NammaPustakaApp
    val students = app.studentRepository.allStudents.asLiveData()
    fun student(id: Int) = app.studentRepository.student(id).asLiveData()
    fun transactions(id: Int) = app.transactionRepository.detailsForStudent(id).asLiveData()
    fun addStudent(student: StudentEntity, done: () -> Unit) = viewModelScope.launch { app.studentRepository.insert(student); done() }
}
