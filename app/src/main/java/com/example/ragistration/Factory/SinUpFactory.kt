package com.example.ragistration.Factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.ViewModel.SinUpViewModel
import com.example.ragistration.repository.SinUpRepository

class SinUpFactory(private val sharePrefRepository: SinUpRepository, private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SinUpViewModel::class.java)){
            return SinUpViewModel(sharePrefRepository,context) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}