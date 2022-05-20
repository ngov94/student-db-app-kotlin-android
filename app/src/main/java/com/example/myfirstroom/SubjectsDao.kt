package com.example.myfirstroom

import androidx.room.*

@Dao
interface SubjectsDao {

    @Insert
    fun insertSubject(subject: Subjects)

    @Query("select * from subjects")
    fun selectSubject(): List<Subjects>

    @Update
    fun updateSubject(subject: Subjects)

    @Delete
    fun  deleteSubject(subject: Subjects)
}