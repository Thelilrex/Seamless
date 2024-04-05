package com.example.seamless.ui.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Type:: class, Category:: class, Income:: class, Expenses:: class, AcquisitionCategory:: class, Assets:: class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun appDao(): AppDao
    companion object {
        @Volatile
        private var Instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {

                return Instance ?: synchronized(this) {
                    Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "seamless_database"
                ).build().also {
                    Instance = it
                }
            }
        }
    }
}