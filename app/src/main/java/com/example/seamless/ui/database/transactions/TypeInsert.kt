package com.example.seamless.ui.database.transactions

sealed interface TypeInsert {
    object SaveType: TypeInsert
    data class SetType(val type: String): TypeInsert
    data class SetDescription(val description: String): TypeInsert
}