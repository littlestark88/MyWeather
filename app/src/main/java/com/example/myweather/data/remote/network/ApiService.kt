package com.example.myweather.data.remote.network

import com.example.myweather.data.remote.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("current.json")
    suspend fun getWeather(
        @Query("key") key: String? = null,
        @Query("q") search: String? = null
    ): WeatherResponse
}