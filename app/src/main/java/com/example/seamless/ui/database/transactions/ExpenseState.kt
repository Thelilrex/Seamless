package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Expenses

data class ExpenseState(
    val expenses: List<Expenses> = emptyList(),
    val categoryID: Int = 0,
    val amount: Double = 0.0,
    val name: String = "",
    val description: String = "",
    val isAddingExpense: Boolean = false,
    val sortExpenses: SortOrder = SortOrder.ID
)
