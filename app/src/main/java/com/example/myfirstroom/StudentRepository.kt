package com.example.myfirstroom

import android.content.Context

//repository provides a set of functions that gets/sets data
//sits b/w application and data source
class StudentRepository(context: Context) {
    var db: StudentsDao? = AppDatabase.getInstance(context)?.studentsDao()

    fun getAllStudents(): List<Students>{
        return db?.selectStudents() ?: listOf<Students>()
    }

    fun insertStudent(student: Students){
        db?.insertStudents(student)
    }

    fun updateStudent(student: Students){
        db?.updateStudents(student)
    }

    fun deleteStudent(student: Students){
        db?.deleteStudents(student)
    }

    //Insert things in an Async way

}