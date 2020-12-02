package com.bdtheme.receipedagger.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bdtheme.receipedagger.api.ReceipeApiService
import com.bdtheme.receipedagger.model.ReceipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(private val apiService: ReceipeApiService) {

    var recipeListMutable: MutableLiveData<List<ReceipeModel>> = MutableLiveData()

    fun fetchRecipeList(): LiveData<List<ReceipeModel>> {
        val receipeCall: Call<List<ReceipeModel>> = apiService.getRecepies()
        receipeCall.enqueue(object : Callback<List<ReceipeModel>> {
            override fun onResponse(
                call: Call<List<ReceipeModel>>,
                response: Response<List<ReceipeModel>>
            ) {
                val receipeList = response.body()
                recipeListMutable.value = receipeList
            }

            override fun onFailure(call: Call<List<ReceipeModel>>, t: Throwable) {
                Log.e("LIst", "empty" + (t.message))
            }

        })

        return recipeListMutable
    }
}