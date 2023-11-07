package com.example.busschedule.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Schedule") // define esta classe como uma entidade da tabela "Schedule" no banco de dados
data class BusSchedule(
    @PrimaryKey // define o campo "id" como a chave primária da tabela
    val id: Int,

    @ColumnInfo(name = "stop_name") // define o nome da coluna no banco de dados como "stop_name"
    val stopName: String,

    @ColumnInfo(name = "arrival_time") // define o nome da coluna no banco de dados como "arrival_time"
    val arrivalTimeInMillis: Int
)
