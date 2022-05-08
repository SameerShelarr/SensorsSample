package com.example.sensorssample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sensorssample.ui.theme.SensorsSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SensorsSampleTheme {
                val viewModel: MainViewModel by viewModels()
                val isDark = viewModel.isDark

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            if (isDark) Color.DarkGray else Color.White
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (isDark) "Its dark" else "Its bright",
                        color = if (isDark) Color.White else Color.Black
                    )
                }
            }
        }
    }
}