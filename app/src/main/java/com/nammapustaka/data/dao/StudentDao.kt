package com.nammapustaka.data.dao

import androidx.room.*
import com.nammapustaka.data.entity.StudentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StudentDao {
    @Query("SELECT * FROM student ORDER BY totalPagesRead DESC")
    fun getAllStudents(): Flow<List<StudentEntity>>

    @Query("SELECT * FROM student WHERE name LIKE '%' || :query || '%' OR rollNumber LIKE '%' || :query || '%' ORDER BY name")
    fun search(query: String): Flow<List<StudentEntity>>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudent(id: Int): Flow<StudentEntity?>

    @Query("SELECT * FROM student WHERE id = :id")
    suspend fun getStudentOnce(id: Int): StudentEntity?

    @Query("UPDATE student SET totalPagesRead = totalPagesRead + :pages WHERE id = :studentId")
    suspend fun addPages(studentId: Int, pages: Int)

    @Insert suspend fun insert(student: StudentEntity): Long
    @Update suspend fun update(student: StudentEntity)
    @Delete suspend fun delete(student: StudentEntity)
}
