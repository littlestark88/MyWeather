package com.example.myweather.presentation.weather

import androidx.lifecycle.*
import com.example.myweather.data.lib.Resource
import com.example.myweather.domain.IWeatherUseCase
import com.example.myweather.domain.model.Weather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val weatherUseCase: IWeatherUseCase): ViewModel() {

    val weather: LiveData<Resource<Weather>> by lazy { _weather }
    private val _weather = MutableLiveData<Resource<Weather>>()

    fun getWeather(apiKey: String, search: String): Flow<Resource<Weather>> {
        _weather.value = Resource.Loading()

        viewModelScope.launch {
            weatherUseCase.getCurrentWeather(apiKey, search).collect {
                _weather.value = it
            }
        }
        return _weather.asFlow()
    }
}