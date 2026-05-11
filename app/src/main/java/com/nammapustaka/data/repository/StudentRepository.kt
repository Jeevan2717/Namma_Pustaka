package com.nammapustaka.data.repository

import com.nammapustaka.data.dao.StudentDao
import com.nammapustaka.data.entity.StudentEntity

class StudentRepository(private val dao: StudentDao) {
    val allStudents = dao.getAllStudents()
    fun search(query: String) = dao.search(query)
    fun student(id: Int) = dao.getStudent(id)
    suspend fun studentOnce(id: Int) = dao.getStudentOnce(id)
    suspend fun insert(student: StudentEntity) = dao.insert(student)
    suspend fun update(student: StudentEntity) = dao.update(student)
}
