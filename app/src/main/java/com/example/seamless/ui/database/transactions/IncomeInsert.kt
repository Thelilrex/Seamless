package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Category
import com.example.seamless.ui.database.Income
import com.example.seamless.ui.database.Type

sealed interface IncomeInsert {
    data object SaveIncome: IncomeInsert
    data class SetCategory (val category: Category): IncomeInsert
    data class SetName (val name: String): IncomeInsert
    data class SetDescription(val description: String): IncomeInsert
    data class SetAmount(val amount: Double): IncomeInsert
    data class DeleteIncome(val income: Income): IncomeInsert
    data class SortIncome(val type: SortOrder): IncomeInsert
}