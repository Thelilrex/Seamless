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
    fun getAllType(): Flow<List<Type>> // We almost never use this

    @Transaction
    @Query("Select * From Category Order By categoryID")
    fun getAllCategory(): Flow<List<Category>> // We might use it but mostly no

    @Transaction
    @Query("Select * From Income Order By date Desc")
    fun getAllIncome(): Flow<List<Income>> // Most used stuff

    @Transaction
    @Query("Select * From Income Where categoryID=:id")
    fun getIncomeByCategory(id : Int): Flow<List<Income>> // Most used stuff
    @Transaction
    @Query("Select * From Income Inner Join Category On Income.categoryID = category.categoryID Where category.typeID=:iD")
    fun getIncomeByType(iD: Int): Flow<List<Income>>

    @Transaction
    @Query("Select * From Expenses Order By date Desc")
    fun getAllExpenses(): Flow<List<Expenses>> // Most used stuff
    @Transaction
    @Query("Select * From Expenses Where categoryID=:id")
    fun getExpensesByCategory(id : Int): Flow<List<Expenses>> // Most used stuff
    @Transaction
    @Query("Select * From Expenses Inner Join Category On Expenses.categoryID = category.categoryID Where category.typeID=:iD")
    fun getExpensesByType(iD: Int): Flow<List<Expenses>>

    @Transaction
    @Query("Select * From AcquisitionCategory Order By acquisitionCatID")
    fun getAllAcquisitionCategory(): Flow<List<AcquisitionCategory>> // Rarely used stuff

    @Transaction
    @Query("Select * From Assets Order By acquiredDate Desc")
    fun getAllAssets(): Flow<List<Assets>> // Most used stuff
    @Transaction
    @Query("Select * From Assets Where acquisitionCatID=:id")
    fun getAssetsByCategory(id : Int): Flow<List<Assets>> // Most used stuff



    // functions for insert
    @Insert
    suspend fun insertType(type: Type) // Used by us to insert the personal and the business types

    @Insert
    suspend fun insertCategory(category: Category) // Used by the user to add a category

    @Insert
    suspend fun insertIncome(income: Income) // Used by user to input the transaction

    @Insert
    suspend fun insertExpenses(expenses: Expenses)

    @Insert
    suspend fun insertAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Insert
    suspend fun insertAsset(assets: Assets)


    // functions for update
    // Mostly useless for the current update
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
    suspend fun deleteType(type: Type) // Rarely if not not used at all
    @Query("Delete From Type Where typeID = :iD")
    suspend fun deleteTypeById(iD: Int) // Rarely or never used

    @Delete
    suspend fun deleteCategory(category: Category) // Future update

    @Delete
    suspend fun deleteIncome(income: Income) // Used by user to delete the income that has been entered [maybe future]
    @Query("Delete From Income Where incomeID = :iD") // Used by user to delete the entry of income based on the id
    suspend fun deleteIncomeById(iD:Int)

    @Delete
    suspend fun deleteExpenses(expenses: Expenses) // Used by user to delete the income that has been entered [maybe future]
    @Query("Delete From Expenses Where expenseID = :iD") // Used by user to delete the entry of income based on the id
    suspend fun deleteExpenseById(iD:Int)

    @Delete
    suspend fun deleteAcquisitionCat(acquisitionCategory: AcquisitionCategory)

    @Delete
    suspend fun deleteAsset(assets: Assets)
    @Query("Delete From Assets Where assetID = :iD")
    suspend fun deleteAssetsById(iD:Int)
}