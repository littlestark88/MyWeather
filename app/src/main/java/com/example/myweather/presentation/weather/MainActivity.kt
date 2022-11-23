package com.example.myweather.presentation.weather

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myweather.R
import com.example.myweather.data.lib.Resource
import com.example.myweather.databinding.ActivityMainBinding
import com.example.myweather.domain.model.Weather
import com.example.myweather.utils.LoadingUtils.hideLoading
import com.example.myweather.utils.LoadingUtils.showLoading
import com.example.myweather.utils.WeatherDataMapper.WEATHER_DATA
import com.example.myweather.utils.showCustomAlertDialogOneButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val weatherViewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAction()
    }

    private fun initAction() {
        with(binding) {
            val apiKey = edtApiKey.text.toString()
            val city = tilCityName.editText.toString()
                edtCityName.setOnClickListener {
                showSimpleDialogName()
                }
            btnSubmit.setOnClickListener {
                if(city.isNotEmpty()) {
                    weatherViewModel.getWeather(apiKey, city)
                    getCurrentWeatherObserver()
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.label_choose_city), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getCurrentWeatherObserver() {
        weatherViewModel.weather.observe(this) {
            when (it) {
                is Resource.Loading -> showLoading(this)
                is Resource.Success -> {
                    hideLoading()
                    intentToDetail(it.data)
                }
                is Resource.Error -> {
                    hideLoading()
                    showCustomAlertDialogOneButton(
                        this,
                        message = getString(R.string.label_failed_current_weather)
                    )
                }
            }
        }
    }

    private fun intentToDetail(data: Weather?) {
        val intent = Intent(this, DetailWeatherActivity::class.java)
        intent.putExtra(WEATHER_DATA, data)
        startActivity(intent)
    }

    private fun showSimpleDialogName(){
        val city = resources.getStringArray(R.array.city)
        val cityAdapter = ArrayAdapter(this,R.layout.list_item_city, city)
        binding.edtCityName.setAdapter(cityAdapter)
    }
}