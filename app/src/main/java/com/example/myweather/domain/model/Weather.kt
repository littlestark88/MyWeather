package com.example.myweather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Weather(
    val currentWeather: CurrentWeather
): Parcelable
