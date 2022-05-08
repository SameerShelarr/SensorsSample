package com.example.sensorssample.sensors

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import com.example.sensorssample.AndroidSensor


class LightSensor(
    context: Context
) : AndroidSensor(
    context = context,
    sensorName = PackageManager.FEATURE_SENSOR_LIGHT,
    sensorType = Sensor.TYPE_LIGHT
) {
}