package com.example.myweather.presentation.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myweather.databinding.ActivityDetailWeatherBinding
import com.example.myweather.domain.model.Weather
import com.example.myweather.utils.WeatherDataMapper.WEATHER_DATA

class DetailWeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = intent.getParcelableExtra<Weather>(WEATHER_DATA)
        with(binding) {
            edtCelsius.setText(data?.currentWeather?.tempC.toString())
            edtFahrenheit.setText(data?.currentWeather?.tempF.toString())
        }
    }
}