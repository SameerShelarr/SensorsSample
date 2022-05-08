package com.example.sensorssample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    lightSensor: MySensor
): ViewModel() {

    var isDark by mutableStateOf(false)

    init {
        lightSensor.startListeningSensor()
        lightSensor.setOnSensorUpdateListener { values ->
            val luminosity = values.first()
            isDark = luminosity < 60f
        }
    }
}