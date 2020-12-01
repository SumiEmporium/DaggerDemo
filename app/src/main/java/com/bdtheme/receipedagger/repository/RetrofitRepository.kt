package com.bdtheme.receipedagger.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bdtheme.receipedagger.MyApplication
import com.bdtheme.receipedagger.api.ReceipeApiService
import com.bdtheme.receipedagger.di.AppComponent
import com.bdtheme.receipedagger.model.ReceipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {

    var recipeListMutable: MutableLiveData<List<ReceipeResponse>> = MutableLiveData()

    @Inject
    lateinit var retrofit: Retrofit

    init {
        val appComponent: AppComponent = MyApplication.appComponent
        appComponent.inject(this)
    }

    fun fetchRecipeList(): LiveData<List<ReceipeResponse>> {
        val apiService: ReceipeApiService = retrofit.create(ReceipeApiService::class.java)
        val receipeCall: Call<List<ReceipeResponse>> = apiService.getRecepies()
        receipeCall.enqueue(object : Callback<List<ReceipeResponse>> {
            override fun onResponse(
                call: Call<List<ReceipeResponse>>,
                response: Response<List<ReceipeResponse>>
            ) {
                val receipeList = response.body()
                recipeListMutable.value = receipeList
            }

            override fun onFailure(call: Call<List<ReceipeResponse>>, t: Throwable) {
                Log.e("LIst", "empty" + (t.message))
            }

        })

        return recipeListMutable
    }
}