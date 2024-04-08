package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Category

data class CategoryState(
    val typeID: Int = 0,
    val category: List<Category> = emptyList(),
    val name: String = "",
    val description: String = "",
    val isAddingCategory: Boolean = false,
    val sortCategory: SortOrder = SortOrder.ID
)
