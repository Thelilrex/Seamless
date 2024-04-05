package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Type

data class TypeState(
    val type:List<Type> = emptyList(),
    val name: String = "",
    val description: String = "",
    val isAddingType: Boolean = false,
)
