package com.bdtheme.receipedagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdtheme.receipedagger.model.ReceipeResponse
import com.bdtheme.receipedagger.repository.RetrofitRepository

class RetroViewModel(retrofitRepository: RetrofitRepository) : ViewModel() {
    var retrofitRepository: RetrofitRepository
    var recipeLiveData: LiveData<List<ReceipeResponse>> = MutableLiveData()

    init {
        this.retrofitRepository = retrofitRepository
        fetchRecipeList()
    }

    fun fetchRecipeList() {
        recipeLiveData = retrofitRepository.fetchRecipeList()
    }
}