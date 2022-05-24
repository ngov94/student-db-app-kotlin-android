package com.example.myfirstroom

import androidx.lifecycle.LiveData

import androidx.room.*

//contract for interacting with DB
@Dao
interface StudentsDao {
    //CRUD op
    //create
    @Insert
    fun insertStudents(student: Students)

    //read
//    @Query("select * from students")
//    fun selectStudents(): List<Students>

    @Query("select * from students")
    fun selectStudents(): LiveData<List<Students>>


    //update
    @Update
    fun updateStudents(student: Students)

    //delete
    @Delete
    fun deleteStudents(student: Students)
}