package com.example.myweather.data

import com.example.myweather.base.ApiResponse
import com.example.myweather.data.lib.NetworkBoundResource
import com.example.myweather.data.lib.Resource
import com.example.myweather.data.remote.WeatherRemoteDataSource
import com.example.myweather.data.remote.response.CurrentWeatherItem
import com.example.myweather.data.remote.response.WeatherResponse
import com.example.myweather.domain.IWeatherRepository
import com.example.myweather.domain.model.CurrentWeather
import com.example.myweather.domain.model.Weather
import com.example.myweather.utils.WeatherDataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WeatherRepository @Inject constructor(
    private val weatherRemoteDataSource: WeatherRemoteDataSource
): IWeatherRepository {
    override fun getCurrentWeather(apiKey: String, search: String): Flow<Resource<Weather>> {
        return object: NetworkBoundResource<Weather, WeatherResponse>() {
            override suspend fun createCall(): Flow<ApiResponse<WeatherResponse>> {
                return weatherRemoteDataSource.getCurrentWeather(apiKey, search)
            }

            override fun fetchFromNetwork(data: WeatherResponse?): Flow<Weather> {
                return flowOf(data).map {
                    WeatherDataMapper.mapWeatherToDomain(data) }
            }
        }.asFlow()
    }
}