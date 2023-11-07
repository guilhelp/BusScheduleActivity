package com.example.busschedule.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// define a classe AppDatabase como um banco de dados Room com as entidades especificadas e a versão.
@Database(entities = arrayOf(BusSchedule::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    // define um método abstrato para acessar o DAO relacionado aos dados de programação de ônibus.
    abstract fun busScheduleDao(): BusDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // cria uma instância do banco de dados
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                )
                    .createFromAsset("database/bus_schedule.db") // inicializa o banco de dados com um arquivo de assets

                    .fallbackToDestructiveMigration() // recria a estrutura de dados caso tenha alguma atualização
                    .build()
                    .also {
                        INSTANCE = it
                    }
            }
        }
    }
}
