package com.example.seamless

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Transaction:: class, Type:: class, Category:: class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    abstract fun typeDao(): TypeDao

    abstract fun categoryDao(): CategoryDao
}