package com.example.myfirstroom

import android.content.Context
import androidx.lifecycle.LiveData

//repository provides a set of functions that gets/sets data
//sits b/w application and data source
class StudentRepository(context: Context) {
    var db: StudentsDao? = AppDatabase.getInstance(context)?.studentsDao()

    fun getAllStudents(): LiveData<List<Students>>? {
        return db?.selectStudents()
    }

//    fun search(searchText: String): LiveData<List<Students>> {
//        return db?.searchStudents(searchText) ?: LiveData<List<Students>>()
//    }

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