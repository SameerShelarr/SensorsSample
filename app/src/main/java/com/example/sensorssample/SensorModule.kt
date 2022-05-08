package com.example.sensorssample

import android.app.Application
import com.example.sensorssample.sensors.LightSensor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SensorModule {

    @Provides
    @Singleton
    fun providesLightSensor(appContext: Application): MySensor = LightSensor(appContext)
}