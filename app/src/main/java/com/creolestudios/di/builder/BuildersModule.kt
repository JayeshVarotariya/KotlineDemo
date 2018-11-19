package com.creolestudios.di.builder

import com.creolestudios.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity():MainActivity

}