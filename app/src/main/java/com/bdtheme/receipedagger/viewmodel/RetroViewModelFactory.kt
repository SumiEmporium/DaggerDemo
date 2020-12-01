package com.bdtheme.receipedagger.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdtheme.receipedagger.MyApplication
import com.bdtheme.receipedagger.repository.RetrofitRepository
import javax.inject.Inject

class RetroViewModelFactory : ViewModelProvider.Factory {
    @Inject
    lateinit var retrofitRepository: RetrofitRepository
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val appComponent = MyApplication.appComponent
        appComponent.inject(this)
        if (modelClass.isAssignableFrom(RetroViewModel::class.java)) {
            return RetroViewModel(retrofitRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
