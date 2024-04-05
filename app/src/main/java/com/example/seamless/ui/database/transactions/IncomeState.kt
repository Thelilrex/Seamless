package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.Income

data class IncomeState(
    val income:List<Income> = emptyList(),
    val amount: Double = 0.0,
    val name: String = "",
    val description: String = "",
    val isAddingIncome: Boolean = false
)
