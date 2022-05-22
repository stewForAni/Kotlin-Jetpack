package com.stew.kotlinjetpack.room

import androidx.room.*

/**
 * Created by stew on 5/22/22.
 * mail: stewforani@gmail.com
 */
@Dao
interface StudentDao {
    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getStudentList(): List<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): Student

}