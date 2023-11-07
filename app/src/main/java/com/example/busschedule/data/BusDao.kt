package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusDao {
    // consulta todas as programações de ônibus ordenadas por horário de chegada
    @Query(
        """
        SELECT * FROM schedule 
        ORDER BY arrival_time ASC    
        """
    )
    fun getAll(): Flow<List<BusSchedule>>

    // consulta as programações de ônibus por nome do ponto de ônibus, ordenadas por horário de chegada
    @Query(
        """
        SELECT * FROM schedule 
        WHERE stop_name = :stopName 
        ORDER BY arrival_time ASC 
        """
    )
    fun getByStopName(stopName: String): Flow<List<BusSchedule>>
}
