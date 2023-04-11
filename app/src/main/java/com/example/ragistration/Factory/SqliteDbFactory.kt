package com.example.ragistration.Factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ragistration.Repository1.SqliteDbReposotory
import com.example.ragistration.ViewModel.SqliteDbViewModel

class SqliteDbFactory(private val repository: SqliteDbReposotory): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SqliteDbViewModel::class.java)){
            return SqliteDbViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}