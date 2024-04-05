package com.example.seamless.ui.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date

// This table tracks assets, stocks and liabilities so basically this is assets table
@Entity(foreignKeys = [ForeignKey(
    entity = Type::class,
    childColumns = ["typeID"],
    parentColumns = ["typeID"]),
    ForeignKey(
        entity = AcquisitionCategory::class,
        childColumns = ["acquisitionCatID"],
        parentColumns = ["acquisitionCatID"]
    )])
data class Assets(
    @PrimaryKey(autoGenerate = true)
    val assetID: Int = 0,
    val typeID: Int,
    val acquisitionCatID: Int,
    val assetsName: String,
    val description:String?,
    val acquiredDate: String,
    val divestmentDate: String?,
    val worth: Double,
)