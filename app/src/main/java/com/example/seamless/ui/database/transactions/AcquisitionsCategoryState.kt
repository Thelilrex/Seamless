package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.AcquisitionCategory

data class AcquisitionsCategoryState(
    val acquisitionCategory: List<AcquisitionCategory> = emptyList(),
    val name: String = "",
    val description: String = "",
    val isAddingAcquisitionCategory: Boolean = false
)
