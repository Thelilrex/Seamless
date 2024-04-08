package com.example.seamless.ui.database.transactions

sealed interface TypeInsert {
    data object SaveType: TypeInsert
    data class SetType(val type: String): TypeInsert
    data class SetDescription(val description: String): TypeInsert
    data class SortType(val type: SortOrder): TypeInsert
}