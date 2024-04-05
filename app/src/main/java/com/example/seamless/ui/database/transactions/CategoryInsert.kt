package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Type

sealed interface CategoryInsert {
    object SaveCategory: CategoryInsert
    data class SetType(val type: Type): CategoryInsert
    data class SetCategory(val category: String): CategoryInsert
    data class SetDescription(val description: String): CategoryInsert
}