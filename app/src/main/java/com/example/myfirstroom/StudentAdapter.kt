package com.example.myfirstroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList:List<Students>) : RecyclerView.Adapter<ViewHolder>(){
    private lateinit var itemListener: OnItemClickListener
    interface OnItemClickListener{
        fun onItemClick (itemView: View)
    }

    fun setOnItemClickListener(listener: OnItemClickListener){
        itemListener = listener
    }

    //inflate a view and return it
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val studentItemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_list_item_layout, parent, false)
        return ViewHolder(studentItemView, itemListener)
    }

    //add element to view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = studentList[position]
        var ptext = ""+ item.firstName.toString().uppercase().subSequence(0,1) + item.lastName.toString().uppercase().subSequence(0,1)
        holder.firstNameTextView.text = item.firstName
        holder.lastNameTextView.text = item.lastName
        holder.studentIDTextView.text = item.studentId.toString()
        holder.profileTextTextView.text = ptext
    }

    //size of the list/ data source
    override fun getItemCount(): Int {
        return studentList.size
    }
}

class ViewHolder(view: View, listener: StudentAdapter.OnItemClickListener) : RecyclerView.ViewHolder(view){
    var firstNameTextView: TextView = view.findViewById(R.id.firstName)
    var lastNameTextView: TextView = view.findViewById(R.id.lastName)
    var studentIDTextView: TextView = view.findViewById(R.id.stdID)
    var profileTextTextView: TextView = view.findViewById(R.id.profile_text)

    init {
        view.setOnClickListener{
            listener.onItemClick(itemView)
        }
    }
}

