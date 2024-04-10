package com.example.seamless

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TransactionDao {
    @Query("SELECT * FROM `transaction`")
    suspend fun getAll(): List<Transaction>


    @Insert
    suspend fun insertAll(vararg transaction: Transaction)

    @Delete
    suspend fun delete(transaction: Transaction)

    @Update
    suspend fun update(vararg transaction: Transaction)
}

@Dao
interface CategoryDao {
    @Query("SELECT * FROM `Category`")
    suspend fun getAll(): List<Category>

    @Insert
    suspend fun insertAll(vararg category: Category)

    @Delete
    suspend fun delete(category: Category)

    @Update
    suspend fun update(vararg category: Category)
}

@Dao
interface TypeDao {
    @Query("SELECT * FROM `Type`")
    suspend fun getAll(): List<Type>

    @Insert
    suspend fun insertAll(vararg type: Type)

    @Delete
    suspend fun delete(type: Type)

    @Update
    suspend fun update(vararg type: Type)
}
