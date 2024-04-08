package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Category
import com.example.seamless.ui.database.Expenses
import com.example.seamless.ui.database.Type

sealed interface ExpenseInsert {
    data object SaveExpense: ExpenseInsert
    data class SetCategory (val category: Category): ExpenseInsert
    data class SetName(val name: String): ExpenseInsert
    data class SetDescription(val description: String): ExpenseInsert
    data class SetAmount(val amount: Double): ExpenseInsert
    data class DeleteExpense(val expenses: Expenses): ExpenseInsert
    data class SortExpenses(val type: SortOrder): ExpenseInsert
}