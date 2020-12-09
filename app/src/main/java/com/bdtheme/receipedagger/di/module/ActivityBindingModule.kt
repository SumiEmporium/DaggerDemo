package com.bdtheme.receipedagger.di.module

import com.bdtheme.receipedagger.ui.MainAc
import com.bdtheme.receipedagger.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindMainJActivity(): MainAc
}