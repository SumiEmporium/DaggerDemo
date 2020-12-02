package com.bdtheme.receipedagger.di

import com.bdtheme.receipedagger.api.ReceipeApiService
import com.bdtheme.receipedagger.repository.APIURL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class ApplicationModule {

    companion object {
        val baseURL = APIURL.BASE_URL
    }

    @Singleton
    @Provides
    fun provideOKHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(1200, TimeUnit.SECONDS)
            .connectTimeout(1200, TimeUnit.SECONDS).build()
    }

    @Singleton
    @Provides
    fun provideGSON(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }


    @Singleton
    @Provides
    fun provideRetrofitService(retrofit: Retrofit): ReceipeApiService {
        return retrofit.create(ReceipeApiService::class.java)
    }
}