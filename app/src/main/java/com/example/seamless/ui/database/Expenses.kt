package com.example.seamless.ui.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

// This is expenses tracker that stores data similar to income it has the category as FK [This is common for
// business = expenses and personal = spending]

/*
Example input:-
Personal ---> Through buttons, Food  ----> Through buttons, 31 March 2024, 7-Eleven, Lunch, 1500.
 */

@Entity(foreignKeys = [ForeignKey(
    entity = Category::class,
    childColumns = ["categoryID"],
    parentColumns = ["categoryID"])])
data class Expenses(
    @PrimaryKey(autoGenerate = true)
    val expenseID: Int = 0,
    val categoryID:Int,
    val date: String = Date.from(Instant.now()).toString(),
    val name: String,
    val description: String?,
    val amount: Double
)