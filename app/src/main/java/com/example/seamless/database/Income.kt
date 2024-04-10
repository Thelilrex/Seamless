package com.example.seamless.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

// This is income table that stores data regarding the income, this table takes category PK as FK
// because this table takes category as FK we also store things based on types
// [This is a common table for both personal = Income and business = Revenue]
/*
Example input: - Type ---> from the buttons, category ----> from buttons, date, Part-Time, My part-time earnings, 1500
 */
@Entity(foreignKeys = [ForeignKey(
    entity = Category::class,
    childColumns = ["categoryID"],
    parentColumns = ["categoryID"],
    onDelete = ForeignKey.CASCADE)])
data class Income(
    @PrimaryKey(autoGenerate = true)
    val incomeID: Int = 0,
    val categoryID:Int,
    val date: String = Date.from(Instant.now()).toString(),
    val name: String,
    val description: String?,
    val amount: Double
)
