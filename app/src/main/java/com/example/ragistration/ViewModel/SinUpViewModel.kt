package com.example.ragistration.ViewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.ragistration.repository.SinUpRepository

class SinUpViewModel(private val sharePrefRepository: SinUpRepository, private val context:Context):ViewModel() {
    fun savedata(mobno:Int){
        sharePrefRepository.getprefrence(context).edit().putInt("Mobile",mobno).commit()

    }
    fun getdata():String{
        var monumber= sharePrefRepository.getprefrence(context).getString("Mobile","")
        return monumber.toString()
    }
}