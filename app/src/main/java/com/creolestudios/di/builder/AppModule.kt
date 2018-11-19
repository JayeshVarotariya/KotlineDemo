package com.creolestudios.di.builder

import android.app.Application
import com.creolestudios.DemoApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val app:DemoApp) {

    @Provides
    @Singleton
    fun provideApplication():DemoApp=app

}