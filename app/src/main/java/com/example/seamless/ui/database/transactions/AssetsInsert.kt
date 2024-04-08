package com.example.seamless.ui.database.transactions

import com.example.seamless.ui.database.AcquisitionCategory
import com.example.seamless.ui.database.Assets
import com.example.seamless.ui.database.Type
import java.util.Date

sealed interface AssetsInsert{
    object SaveAsset: AssetsInsert
    data class SetType(val type: Type): AssetsInsert
    data class SetAcquisitionCategory(val acquisitionCategory: AcquisitionCategory): AssetsInsert
    data class SetName(val name: String): AssetsInsert
    data class SetDescription(val description: String): AssetsInsert
    data class SetAcquiredDate(val date: Date): AssetsInsert
    data class SetDivestmentDate(val date: Date): AssetsInsert
    data class SetWorth(val worth: Double): AssetsInsert
    data class DeleteAsset(val assets: Assets): AssetsInsert
    data class SortAssets(val type: SortOrder): AssetsInsert
}