package com.example.ragistration.ViewModel

import androidx.lifecycle.ViewModel
import com.example.ragistration.Repository1.SqliteDbReposotory

class SqliteDbViewModel(private val repository:SqliteDbReposotory):ViewModel(){

fun createData(fName: String, lName: String, phone: String,email:String,dob:String,gender:String,course:String) {
    repository.createData(fName,lName,phone,email,dob,gender,course)
}

}