package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_student.*
import kotlinx.android.synthetic.main.activity_modify_student.*
import kotlinx.android.synthetic.main.activity_modify_student.btnCancel

class ModifyStudent : AppCompatActivity() {

   // val repo:StudentRepository = StudentRepository(this)
   lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_student)

        vm = MainViewModel(application)

        val intent = getIntent()
        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val stdID = intent.getStringExtra("stdID")

        modFName.hint = firstName
        modLName.hint = lastName
        stdIDmod.text = "Student ID = "+stdID

        btnUpdate.setOnClickListener {
            var modFirstName = modFName.text.toString()
            var modLastName = modLName.text.toString()

            if (stdID != null) {
                vm.updateStudent(Students(studentId = stdID.toInt(),firstName = modFirstName, lastName = modLastName))
                Toast.makeText(this, "$modFirstName $modLastName has been updated.", Toast.LENGTH_LONG).show()
            }
            var intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }

        btnCancel.setOnClickListener {
            var intentMain = Intent(this, MainActivity::class.java)
            startActivity(intentMain)
        }








    }
}