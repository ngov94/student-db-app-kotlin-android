package com.example.myfirstroom

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//app is the context
class MainViewModel (app: Application): AndroidViewModel(app) {
    private val repo: StudentRepository
    //don't want the user to accidentally to call the repository
    val allStudents: LiveData<List<Students>>?
    init{
        repo = StudentRepository(app)
        allStudents = repo.getAllStudents()
    }
    //context is the
    //"this" is a caller

    fun getAllStudents() = viewModelScope.launch{
        repo.getAllStudents()
    }
//    fun search(searchText: String) = viewModelScope.launch {
//        repo.search(searchText)
//    }

    fun insertStudent(student: Students) = viewModelScope.launch{
        repo.insertStudent(student)
    }

    fun updateStudent(student: Students) = viewModelScope.launch{
        repo.updateStudent(student)
    }

    fun deleteStudent(student: Students) = viewModelScope.launch{
        repo.deleteStudent(student)
    }
}