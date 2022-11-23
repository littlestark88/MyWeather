package com.example.myweather.di

import com.example.myweather.data.WeatherRepository
import com.example.myweather.domain.IWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(weatherRepository: WeatherRepository): IWeatherRepository
}