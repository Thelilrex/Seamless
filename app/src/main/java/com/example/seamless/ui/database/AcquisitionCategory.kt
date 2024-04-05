package com.example.seamless.ui.database

import androidx.room.Entity
import androidx.room.PrimaryKey


// This table has the sub types of assets i.e., physical, NFT etc.,
@Entity
data class AcquisitionCategory(
    @PrimaryKey(autoGenerate = true)
    val acquisitionCatID: Int = 0,
    val name: String,
    val description: String?
)