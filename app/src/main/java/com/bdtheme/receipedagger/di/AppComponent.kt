package com.bdtheme.receipedagger.di

import com.bdtheme.receipedagger.MainActivity
import com.bdtheme.receipedagger.repository.RetrofitRepository
import com.bdtheme.receipedagger.viewmodel.RetroViewModelFactory
import com.example.myapplication.AppModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {
    fun inject(repository: RetrofitRepository)
    fun inject(retroViewModelFactory: RetroViewModelFactory)

    fun inject(mainActivity: MainActivity)
}