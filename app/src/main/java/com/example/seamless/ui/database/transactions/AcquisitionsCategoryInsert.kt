package com.example.seamless.ui.database.transactions



sealed interface AcquisitionsCategoryInsert {
    data object SaveAcquisition: AcquisitionsCategoryInsert
    data class SetName(val name: String): AcquisitionsCategoryInsert
    data class SetDescription(val description: String): AcquisitionsCategoryInsert
    data class SortAcquisitions(val type: SortOrder): AcquisitionsCategoryInsert

}