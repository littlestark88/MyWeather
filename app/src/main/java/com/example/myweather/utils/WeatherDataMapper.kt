package com.example.myweather.utils

import com.example.myweather.data.remote.response.CurrentWeatherItem
import com.example.myweather.data.remote.response.WeatherResponse
import com.example.myweather.domain.model.CurrentWeather
import com.example.myweather.domain.model.Weather

object WeatherDataMapper {
    fun mapWeatherToDomain(data: WeatherResponse?): Weather {
        return Weather(
                currentWeather = mapCurrentWeatherToWeather(data?.current)
            )

    }

    private fun mapCurrentWeatherToWeather(data: CurrentWeatherItem?) = CurrentWeather (
        tempF = data?.tempF ?: 0.0,
        tempC = data?.tempC ?: 0.0
    )
    const val WEATHER_DATA = "weather_data"
}