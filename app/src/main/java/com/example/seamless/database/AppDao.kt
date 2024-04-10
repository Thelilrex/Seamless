package com.example.seamless.database

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
    @Query("Select * From Type Order By typeID")
    fun getAllType(): Flow<List<Type>>

    @Transaction
    @Query("Select * From Category Order By categoryID")
    fun getAllCategory(): Flow<List<Category>>

    @Transaction
    @Query("Select * From Income Order By date Desc")
    fun getAllIncome(): Flow<List<Income>>

    @Transaction
    @Query("Select * From Income Where categoryID=:id")
    fun getIncomeByCategory(id : Int): Flow<List<Income>>

    @Transaction
    @Query("Select * From Expenses Order By date Desc")
    fun getAllExpenses(): Flow<List<Expenses>>
    @Transaction
    @Query("Select * From Expenses Where categoryID=:id")
    fun getExpensesByCategory(id : Int): Flow<List<Expenses>>

    @Transaction
    @Query("Select * From AcquisitionCategory Order By acquisitionCatID")
    fun getAllAcquisitionCategory(): Flow<List<AcquisitionCategory>>

    @Transaction
    @Query("Select * From Assets Order By acquiredDate Desc")
    fun getAllAssets(): Flow<List<Assets>>
    @Transaction
    @Query("Select * From Assets Where acquisitionCatID=:id")
    fun getAssetsByCategory(id : Int): Flow<List<Assets>>



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
    @Query("Delete From Type Where typeID = :iD")
    suspend fun deleteTypeById(iD: Int)

    @Delete
    suspend fun deleteCategory(category: Category)

    @Delete
    suspend fun deleteIncome(income: Income)
    @Query("Delete From Income Where incomeID = :iD")
    suspend fun deleteIncomeById(iD:Int)

    @Delete
    suspend fun deleteExpenses(expenses: Expenses)
    @Query("Delete From Expenses Where expenseID = :iD")
    suspend fun deleteExpenseById(iD:Int)

    @Delete
    suspend fun deleteAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Delete
    suspend fun deleteAsset(assets: Assets)
    @Query("Delete From Assets Where assetID = :iD")
    suspend fun deleteAssetsById(iD:Int)

}