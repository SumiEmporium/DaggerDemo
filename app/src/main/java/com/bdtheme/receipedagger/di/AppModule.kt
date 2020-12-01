package com.example.myapplication

import com.bdtheme.receipedagger.MyApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule constructor(myRetroApplication: MyApplication) {

    var myApplication: MyApplication

    init {
        this.myApplication = myRetroApplication
    }

    @Provides
    fun provideMyRetroApplication(): MyApplication {
        return myApplication
    }
}