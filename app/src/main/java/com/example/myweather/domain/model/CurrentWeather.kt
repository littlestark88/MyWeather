package com.example.myweather.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentWeather(
    val tempC: Double,
    val tempF: Double
): Parcelable
