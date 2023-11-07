package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusDao
import com.example.busschedule.data.BusSchedule
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val busScheduleDao: BusDao) : ViewModel() {

    // obtém a programação completa de ônibus
    fun getFullSchedule(): Flow<List<BusSchedule>> = busScheduleDao.getAll()

    // obtém a programação de ônibus para um ponto de parada específico
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        busScheduleDao.getByStopName(stopName)

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // obtém a instância da aplicação do aplicativo para acessar o banco de dados
                val application = (this[APPLICATION_KEY] as BusScheduleApplication)

                // cria e retorna uma instância do BusScheduleViewModel com o DAO apropriado
                BusScheduleViewModel(application.database.busScheduleDao())
            }
        }
    }
}
