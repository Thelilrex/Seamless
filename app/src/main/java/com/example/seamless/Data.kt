package com.example.seamless

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.w3c.dom.Text
import java.util.Date

@Entity
data class Type(
    @PrimaryKey(autoGenerate = true)
    val typeID: Int,
    val type: String,
    val description:String
)
@Entity(foreignKeys = [ForeignKey(
    entity = Type::class,
    childColumns = ["typeID"],
    parentColumns = ["fkID"]
)])
data class Category(
    @PrimaryKey(autoGenerate = true)
    val categoryID: Int,
    val fkID: Int,
    val typeID: Int,
    val category: String,
    val description:String

)

@Entity(foreignKeys = [ForeignKey(
    entity = Category::class,
    childColumns = ["categoryID"],
    parentColumns = ["fkID"])])
data class Transaction(
    @PrimaryKey(autoGenerate = true)
    val transactionID: Int,
    val fkID:Int,
    val date: Date,
    val name: String,
    val description: String,
    val amount: Double
)