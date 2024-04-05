package com.example.seamless.ui.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface AppDao{
    // functions for extracting all the data from the table
    @Transaction
    @Query("Select * From Type")
    fun getAllType(): Flow<List<Type>>

    @Transaction
    @Query("Select * From Category")
    fun getAllCategory(): Flow<List<Category>>

    @Transaction
    @Query("Select * From Income")
    fun getAllIncome(): Flow<List<Income>>

    @Transaction
    @Query("Select * From Expenses")
    fun getAllExpenses(): Flow<List<Expenses>>

    @Transaction
    @Query("Select * From AcquisitionCategory")
    fun getAllAcquisitionCategory(): Flow<List<AcquisitionCategory>>

    @Transaction
    @Query("Select * From Assets")
    fun getAllAssets(): Flow<List<Assets>>

    /*@Query("TRUNCATE Table Type")
    fun deleteAllType()*/


    // functions for insert
    @Insert
    suspend fun insertType(type: Type)

    @Insert
    suspend fun insertCategory(category: Category)

    @Insert
    suspend fun insertIncome(income: Income)

    @Insert
    suspend fun insertExpenses(expenses: Expenses)

    @Insert
    suspend fun insertAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Insert
    suspend fun insertAsset(assets: Assets)


    // functions for update
    @Update
    suspend fun updateType(type: Type)

    @Update
    suspend fun updateCategory(category: Category)

    @Update
    suspend fun updateIncome(income: Income)

    @Update
    suspend fun updateExpenses(expenses: Expenses)

    @Update
    suspend fun updateAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Update
    suspend fun updateAsset(assets: Assets)


    // functions for deletion
    @Delete
    suspend fun deleteType(type: Type)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Delete
    suspend fun deleteIncome(income: Income)

    @Delete
    suspend fun deleteExpenses(expenses: Expenses)

    @Delete
    suspend fun deleteAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Delete
    suspend fun deleteAsset(assets: Assets)

}