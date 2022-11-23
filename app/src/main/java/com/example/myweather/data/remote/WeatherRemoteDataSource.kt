package com.example.myweather.data.remote

import android.util.Log
import com.example.myweather.base.ApiResponse
import com.example.myweather.data.lib.Resource
import com.example.myweather.data.remote.network.ApiService
import com.example.myweather.data.remote.response.WeatherResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRemoteDataSource @Inject constructor(private val apiService: ApiService) {

    fun getCurrentWeather(apiKey: String, search: String): Flow<ApiResponse<WeatherResponse>> {
        return flow {
            try {
                val response = apiService.getWeather(apiKey, search)
                    emit(ApiResponse.Success(response))
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}