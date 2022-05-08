package com.example.sensorssample

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

abstract class AndroidSensor(
    private val context: Context,
    private val sensorName: String,
    sensorType: Int,
) : MySensor(sensorType = sensorType), SensorEventListener {

    private lateinit var sensorManager: SensorManager

    private var sensor: Sensor? = null

    override val isSensorSupported: Boolean
        get() = context.packageManager.hasSystemFeature(sensorName)

    override fun startListeningSensor() {
        if (!isSensorSupported) {
            return
        }

        if (!::sensorManager.isInitialized && sensor == null) {
            sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
            sensor = sensorManager.getDefaultSensor(sensorType)
        }

        sensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun stopListeningSensor() {
        if (!isSensorSupported || !::sensorManager.isInitialized) {
            return
        }
        sensorManager.unregisterListener(this)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (!isSensorSupported) {
            return
        }
        if (event?.sensor?.type == sensorType) {
            onSensorUpdateReceived?.invoke(event.values.toList())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) = Unit
}