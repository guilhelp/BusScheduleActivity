package com.example.busschedule

import android.app.Application
import com.example.busschedule.data.AppDatabase

class BusScheduleApplication : Application() {
    // cria uma instância lazy do banco de dados quando necessário
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}
