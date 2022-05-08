package com.example.sensorssample


abstract class MySensor(
    protected val sensorType: Int
) {
    abstract val isSensorSupported: Boolean
    abstract fun startListeningSensor()
    abstract fun stopListeningSensor()
    protected var onSensorUpdateReceived: ((List<Float>) -> Unit)? = null
    fun setOnSensorUpdateListener(listener: ((List<Float>) -> Unit)) {
        onSensorUpdateReceived = listener
    }
}