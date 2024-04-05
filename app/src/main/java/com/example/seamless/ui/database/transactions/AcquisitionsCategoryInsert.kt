package com.example.seamless.ui.database.transactions



sealed interface AcquisitionsCategoryInsert {
    object SaveAcquisition: AcquisitionsCategoryInsert
    data class SetName(val name: String): AcquisitionsCategoryInsert
    data class SetDescription(val description: String): AcquisitionsCategoryInsert
}