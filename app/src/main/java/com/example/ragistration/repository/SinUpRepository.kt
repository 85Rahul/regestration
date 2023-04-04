package com.example.ragistration.repository

import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE

private const val FileName:String="prefs"
private const val MODE = MODE_PRIVATE

object SinUpRepository {
    fun getprefrence(context:Context):SharedPreferences{
        return context.getSharedPreferences(FileName,MODE)

    }
}