package com.example.ragistration.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.ragistration.repository.SinUpRepository

class SinUpViewModel(private val sharePrefRepository: SinUpRepository, private val context:Context):ViewModel() {
    fun savedata(fname:String,lname:String,mobno:String){
        sharePrefRepository.getprefrence(context).edit().putString(Keys.FNAME,fname).commit()
        sharePrefRepository.getprefrence(context).edit().putString(Keys.LNAME,lname).commit()
        sharePrefRepository.getprefrence(context).edit().putString(Keys.MOBNO,mobno).commit()

    }
    fun getdata():String{
        var monumber= sharePrefRepository.getprefrence(context).getString(Keys.MOBNO,"")
        return monumber!!
    }
}