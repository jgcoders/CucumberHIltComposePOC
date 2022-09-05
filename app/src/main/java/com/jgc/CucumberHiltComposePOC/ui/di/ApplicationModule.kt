package com.jgc.CucumberHiltComposePOC.ui.di

import com.jgc.CucumberHiltComposePOC.ui.generator.NumberGenerator
import com.jgc.CucumberHiltComposePOC.ui.generator.NumberGeneratorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Provides
    @Singleton
    fun providesNumberGenerator(): NumberGenerator = NumberGeneratorImpl()
}