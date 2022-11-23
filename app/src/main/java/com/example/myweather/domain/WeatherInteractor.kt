package com.example.myweather.domain

import javax.inject.Inject

class WeatherInteractor @Inject constructor(
    private val weatherRepository: IWeatherRepository
): IWeatherUseCase {
    override fun getCurrentWeather(apiKey: String, search: String) =
        weatherRepository.getCurrentWeather(apiKey,search)
}