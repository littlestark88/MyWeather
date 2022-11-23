package com.example.myweather.domain

import com.example.myweather.data.lib.Resource
import com.example.myweather.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface IWeatherUseCase {
    fun getCurrentWeather(apiKey: String, search: String): Flow<Resource<Weather>>
}