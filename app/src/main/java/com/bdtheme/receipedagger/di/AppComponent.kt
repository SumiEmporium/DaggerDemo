package com.bdtheme.receipedagger.di

import com.bdtheme.receipedagger.MainActivity
import com.bdtheme.receipedagger.repository.RetrofitRepository
import com.bdtheme.receipedagger.viewmodel.ViewModelFactory
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {
    fun inject(repository: RetrofitRepository)
    fun inject(retroViewModelFactory: ViewModelFactory)

    fun inject(mainActivity: MainActivity)
}