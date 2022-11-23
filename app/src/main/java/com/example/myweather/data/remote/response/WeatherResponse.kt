package com.example.myweather.data.remote.response

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("current")
    val current: CurrentWeatherItem
)
