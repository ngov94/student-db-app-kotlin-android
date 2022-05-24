package com.example.myfirstroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.student_list_item_layout.view.*

class MainActivity : AppCompatActivity() {

//    val repo:StudentRepository by lazy{
//        StudentRepository(this)
//    }

    lateinit var vm: MainViewModel
    var studentList =  ArrayList<Students>()
    var adapter = StudentAdapter(studentList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vm = MainViewModel(application)

        vm.allStudents?.observe(this) { studentList ->
            getStudents(studentList)
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //create an adapter with data source
//        var adapter = StudentAdapter(studentList)
        //Bind custom adapter to the recyclerView
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Insert
        btnAddStudent.setOnClickListener {
            val intentAddStudent = Intent(this,AddStudent::class.java)
            startActivity(intentAddStudent)
        }

        //update
        adapter.setOnItemClickListener(object: StudentAdapter.OnItemClickListener{
            override fun onItemClick(stuView: View) {
                val intentModStudent = Intent(this@MainActivity,ModifyStudent::class.java)
                intentModStudent.putExtra("firstName",stuView.firstName.text.toString())
                intentModStudent.putExtra("lastName", stuView.lastName.text.toString())
                intentModStudent.putExtra("stdID", stuView.stdID.text.toString())
                startActivity(intentModStudent)
            }

        })

        //delete
        val swipeDelete = object : SwipeDelete(){
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val stid = viewHolder.itemView.stdID.text.toString().toInt()
                val fn = viewHolder.itemView.firstName.text.toString()
                val ln = viewHolder.itemView.lastName.text.toString()
                vm.deleteStudent(Students(stid, fn, ln))
                Toast.makeText(this@MainActivity, "$fn $ln has been deleted", Toast.LENGTH_LONG).show()
                studentList.removeAt(position)
                recyclerView.adapter?.notifyItemRemoved(position)

            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeDelete)
        itemTouchHelper.attachToRecyclerView((recyclerView))

    }

    fun getStudents(studentList: List<Students>){
        this.studentList.clear()
        this.studentList.addAll(studentList)
        adapter.notifyDataSetChanged()//let adapter know the data changed
    }
}