package com.example.myfirstroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "students")
data class Students(@PrimaryKey(autoGenerate = true) var studentId: Int? = null,
                    @ColumnInfo(name = "firstname") var firstName: String?,
                    @ColumnInfo(name = "lastname") var lastName: String?)

//@Entity(tableName = "subjects")
//data class Subjects(var name: String){
//    @PrimaryKey(autoGenerate = true) var subjectId: Int? = null
//}

//@Entity(tableName = "enrollment")
//data class Enrollment(@PrimaryKey(autoGenerate = true) var enrollmentId: Int,
//                      @ForeignKey() var studentId: Int,
//                      @ForeignKey() var subjectId: Int)