package com.creolestudios.di

import android.app.Application
import com.creolestudios.DemoApp
import com.creolestudios.di.builder.AppModule
import com.creolestudios.di.builder.BuildersModule
import com.creolestudios.di.builder.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class,BuildersModule::class,AppModule::class,NetModule::class)
)
interface AppComponets {

    fun inject(app:DemoApp)

}