package com.example.ragistration.Repository1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast


private const val DB_NAME = "_db_chetu"
private const val DB_VERSION = 1
private const val TABLE_NAME = "student"
private const val FNAME = "FirstName"
private const val LNAME = "LastName"
private const val PHONE = "Phone"
private const val EMAIL="email"
private const val DOB="dob"
private const val GENDER="gender"
private const val COURSE="course"
private const val SRNO = "Sr"
private const val QUERY="query"

class SqliteDbReposotory(private val context: Context) {

    val query =
        "CREATE TABLE $TABLE_NAME($SRNO INTEGER PRIMARY KEY AUTOINCREMENT, $FNAME TEXT, $LNAME TEXT, $PHONE TEXT,$EMAIL TEXT, $DOB TEXT,$GENDER TEXT,$COURSE TEXT)"

    val dbHelper = MyDbHelper(context)
    val sqliteDb = dbHelper.writableDatabase


    fun createData(fName: String, LName: String, phone: String,email:String,dob:String,gender:String,course:String) {
        val contentValue = ContentValues()
        contentValue.put(FNAME, fName)
        contentValue.put(LNAME, LName)
        contentValue.put(PHONE, phone)
        contentValue.put(EMAIL, email)
        contentValue.put(DOB, dob)
        contentValue.put(GENDER, gender)
        contentValue.put(COURSE, course)
        contentValue.put(QUERY,query)
        val id: Long = sqliteDb.insert(TABLE_NAME, null, contentValue)
        if (id > 0) {
            Toast.makeText(context, "Data Saved Successfully.", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    fun getdata()


    inner class MyDbHelper(private val context:Context):SQLiteOpenHelper(context, DB_NAME,null,
       DB_VERSION){
       override fun onCreate(sqlitedb: SQLiteDatabase?) {
           sqliteDb.execSQL(query)
       }

       override fun onUpgrade(sqlitedb: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
           TODO("Not yet implemented")
       }

   }
    }