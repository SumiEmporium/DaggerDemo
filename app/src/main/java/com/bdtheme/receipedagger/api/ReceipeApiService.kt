package com.bdtheme.receipedagger.api

import com.bdtheme.receipedagger.model.ReceipeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ReceipeApiService {
    @GET("recipes")
    fun getRecepies(): Call<List<ReceipeResponse>>
}