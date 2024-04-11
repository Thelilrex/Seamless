package com.example.seamless.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


// This table has the sub types of assets i.e., physical, NFT etc.,
@Entity(foreignKeys = [ForeignKey(
entity = Type::class,
childColumns = ["typeID"],
parentColumns = ["typeID"]
)])
data class AcquisitionCategory(
    @PrimaryKey(autoGenerate = true)
    val acquisitionCatID: Int = 0,
    val typeID: Int = 0,
    val name: String,
    val description: String?
)