package com.bdtheme.receipedagger.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdtheme.receipedagger.model.ReceipeModel
import com.bdtheme.receipedagger.repository.RetrofitRepository
import javax.inject.Inject

class RetroViewModel @Inject constructor(private val retrofitRepository: RetrofitRepository) : ViewModel() {

    var recipeLiveData: LiveData<List<ReceipeModel>> = MutableLiveData()

    init {
        fetchRecipeList()
    }

    fun fetchRecipeList() {
        recipeLiveData = retrofitRepository.fetchRecipeList()
    }
}