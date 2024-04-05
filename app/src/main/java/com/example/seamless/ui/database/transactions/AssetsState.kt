package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Assets
import java.time.Instant
import java.util.Date

data class AssetsState(
    val assets: List<Assets> = emptyList(),
    val name: String = "",
    val description: String = "",
    val acquiredDate: String = Date.from(Instant.now()).toString(),
    val divestmentDate: String ?= null,
    val worth: Double = 0.0,
    val isAddingAsset: Boolean = false
    )
