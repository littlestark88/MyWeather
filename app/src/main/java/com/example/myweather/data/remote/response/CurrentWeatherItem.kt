package com.example.myweather.data.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherItem(
    @SerializedName("temp_c")
    val tempC: Double? = 0.0,

    @SerializedName("temp_f")
    val tempF: Double? = 0.0
)
