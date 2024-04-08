package com.example.seamless.ui.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


// This stores the data for the types i.e., type like personal or business
/*
Example input: -
Personal, Personal finance tracker
 */
@Entity
data class Type(
    @PrimaryKey(autoGenerate = true)
    val typeID: Int = 0,
    @ColumnInfo(name = "type")
    val type: String,
    val description:String?
)