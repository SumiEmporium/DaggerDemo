package com.bdtheme.receipedagger.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bdtheme.receipedagger.MyApplication
import com.bdtheme.receipedagger.api.ReceipeApiService
import com.bdtheme.receipedagger.di.AppComponent
import com.bdtheme.receipedagger.model.ReceipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {

    var recipeListMutable: MutableLiveData<List<ReceipeModel>> = MutableLiveData()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        val appComponent: AppComponent = MyApplication.appComponent
        appComponent.inject(this)
    }

    fun fetchRecipeList(): LiveData<List<ReceipeModel>> {
        val apiService: ReceipeApiService = retrofit.create(ReceipeApiService::class.java)
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