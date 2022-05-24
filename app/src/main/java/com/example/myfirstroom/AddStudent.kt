package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_student.*


class AddStudent : AppCompatActivity() {

    //val repo:StudentRepository = StudentRepository(this)
    lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        vm = MainViewModel(application)

        btnCancel.setOnClickListener {
            var intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }

        btnSave.setOnClickListener {
            var firstName = addFName.text.toString()
            var lastName = addLName.text.toString()

            var addS = Students(firstName = firstName, lastName = lastName)
            vm.insertStudent(addS)
            Toast.makeText(this, "Saved $firstName $lastName", Toast.LENGTH_LONG).show()
            var intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }
    }
}