package com.example.busschedule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.busschedule.ui.BusScheduleApp
import com.example.busschedule.ui.theme.BusScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // define o tema da interface do usuário usando BusScheduleTheme
            BusScheduleTheme {
                // define a composição principal do aplicativo usando BusScheduleApp
                BusScheduleApp()
            }
        }
    }
}