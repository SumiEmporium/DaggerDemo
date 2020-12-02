package com.bdtheme.receipedagger.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdtheme.receipedagger.viewmodel.RetroViewModel
import com.bdtheme.receipedagger.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RetroViewModel::class)
    abstract fun bindSplashViewModel(viewModel: RetroViewModel): ViewModel
}