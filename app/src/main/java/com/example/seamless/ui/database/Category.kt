package com.example.seamless.ui.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

// This stores the categories that take the type and associate the category with the typeDivision
// i.e., groceries, transport, investment etc.,

/*
Example Input:-
Personal -> you get this through the button id you click, Food, Place to see how much I spend on my food
 */
@Entity(foreignKeys = [ForeignKey(
    entity = Type::class,
    childColumns = ["typeID"],
    parentColumns = ["typeID"]
)])
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryID: Int = 0,
    val typeID: Int,
    val category: String,
    val description:String?
)