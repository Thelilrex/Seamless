package com.example.seamless.ui.database.transactions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.seamless.ui.database.AcquisitionCategory
import com.example.seamless.ui.database.AppDao
import com.example.seamless.ui.database.Assets
import com.example.seamless.ui.database.Category
import com.example.seamless.ui.database.Expenses
import com.example.seamless.ui.database.Income
import com.example.seamless.ui.database.Type
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class TransactionViewModel (private val dao: AppDao): ViewModel()
{
    // Type view model
    private val _sortTypeOrder = MutableStateFlow(SortOrder.ID)
    private val _typeTransactions = _sortTypeOrder
        .flatMapLatest {sortTypeOrder ->
            when(sortTypeOrder){
                SortOrder.ID -> dao.getAllType()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _typeState = MutableStateFlow(TypeState())
    val typeState = combine(_typeState, _sortTypeOrder, _typeTransactions){state, sortOrder, transaction ->
        state.copy(
            type = transaction,
            sortType = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), TypeState())

    fun typeEvent(event: TypeInsert)
    {
        when(event){
            TypeInsert.SaveType -> {
                val name = typeState.value.name
                val description = typeState.value.description

                if(name.equals(""))
                {
                    return
                }

                val type = Type(
                    type = name,
                    description = description
                )
                viewModelScope.launch {
                    dao.insertType(type)
                }
                _typeState.update { it.copy(
                    isAddingType = false,
                    name = "",
                    description = ""
                ) }
            }

            is TypeInsert.SetDescription -> {
                _typeState.update { it.copy(
                    description = event.description
                ) }
            }
            is TypeInsert.SetType -> {
                _typeState.update { it.copy(
                    name = event.type
                ) }
            }
            is TypeInsert.SortType -> {
                _sortTypeOrder.value = SortOrder.ID
            }
        }
    }


    // Category view model
    private val _sortCategoryOrder = MutableStateFlow(SortOrder.ID)
    private val _categoryTransactions = _sortCategoryOrder
        .flatMapLatest {sortCategoryOrder ->
            when(sortCategoryOrder){
                SortOrder.ID -> dao.getAllCategory()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _categoryState = MutableStateFlow(CategoryState())
    val categoryState = combine(_categoryState, _sortCategoryOrder, _categoryTransactions){state, sortOrder, transaction ->
        state.copy(
            category = transaction,
            sortCategory = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), CategoryState())
    fun categoryEvent(event: CategoryInsert, screenType: Int)
    {
        when(event){
            CategoryInsert.SaveCategory -> {
                val name = categoryState.value.name
                val description = categoryState.value.description
                if(name.equals(""))
                {
                    return
                }
                val category = Category(
                    category = name,
                    description = description,
                    typeID = screenType
                )
                viewModelScope.launch {
                    dao.insertCategory(category)
                }
                _categoryState.update {it.copy(
                    isAddingCategory = false,
                    name = "",
                    description = ""
                ) }
            }
            is CategoryInsert.SetCategory -> {
                _categoryState.update { it.copy(
                    name = event.category
                ) }
            }
            is CategoryInsert.SetDescription -> {
                _categoryState.update { it.copy(
                    description = event.description
                ) }
            }

            // Not sure if it works
            is CategoryInsert.SetType -> {
                _categoryState.update {it.copy(
                    typeID = screenType
                )}
            }
            is CategoryInsert.SortCategory -> {
                _sortCategoryOrder.value = SortOrder.ID
            }
        }
    }


    // Income view model
    private val _sortIncomeOrder = MutableStateFlow(SortOrder.ID)
    private val _incomeTransactions = _sortIncomeOrder
        .flatMapLatest {sortIncomeOrder ->
            when(sortIncomeOrder){
                SortOrder.ID -> dao.getAllIncome()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _incomeState = MutableStateFlow(IncomeState())
    val incomeState = combine(_incomeState, _sortIncomeOrder, _incomeTransactions){state, sortOrder, transaction ->
        state.copy(
            income = transaction,
            sortIncome = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), IncomeState())
    fun incomeEvent(event: IncomeInsert, screenType: Int)
    {
        when(event){
            is IncomeInsert.DeleteIncome -> {
                viewModelScope.launch {
                    dao.deleteIncome(event.income)
                }
                _incomeState.update {it.copy(
                    isAddingIncome = false
                )
                }
            }
            IncomeInsert.SaveIncome -> {
                val name = incomeState.value.name
                val description = incomeState.value.description
                if(name.equals(""))
                {
                    return
                }
                val income = Income(
                    name = name,
                    description = description,
                    categoryID = screenType,
                    amount = incomeState.value.amount
                )
                viewModelScope.launch {
                    dao.insertIncome(income)
                }
                _incomeState.update {it.copy(
                    isAddingIncome = false,
                    name = "",
                    description = "",
                    amount = 0.0
                ) }
            }
            is IncomeInsert.SetAmount ->
            {
                _incomeState.update { it.copy(
                    amount = event.amount
                )  }
            }
            is IncomeInsert.SetCategory -> {
                _incomeState.update {
                    it.copy(
                     categoryID = screenType
                    )
                }
            }
            is IncomeInsert.SetDescription -> {
                _incomeState.update { it.copy(
                    description = event.description
                ) }
            }
            is IncomeInsert.SetName -> {
                _incomeState.update { it.copy(
                    name = event.name
                ) }
            }
            is IncomeInsert.SortIncome -> {
                _sortIncomeOrder.value = SortOrder.ID
            }
        }
    }


    // Expenses view model
    private val _sortExpenseOrder = MutableStateFlow(SortOrder.ID)
    private val _expenseTransactions = _sortExpenseOrder
        .flatMapLatest {sortExpenseOrder ->
            when(sortExpenseOrder){
                SortOrder.ID -> dao.getAllExpenses()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _expenseState = MutableStateFlow(ExpenseState())
    val expenseState = combine(_expenseState, _sortExpenseOrder, _expenseTransactions){state, sortOrder, transaction ->
        state.copy(
            expenses = transaction,
            sortExpenses = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ExpenseState())
    fun expenseEvent(event: ExpenseInsert, screenType: Int)
    {
        when(event)
        {
            is ExpenseInsert.DeleteExpense -> {
                viewModelScope.launch {
                    dao.deleteExpenses(event.expenses)
                }
                _expenseState.update {it.copy(
                    isAddingExpense = false
                )
                }
            }
            ExpenseInsert.SaveExpense -> {
                val name = expenseState.value.name
                val description = expenseState.value.description
                if(name.equals(""))
                {
                    return
                }
                val expense = Expenses(
                    name = name,
                    description = description,
                    categoryID = screenType,
                    amount = expenseState.value.amount
                )
                viewModelScope.launch {
                    dao.insertExpenses(expense)
                }
                _expenseState.update {it.copy(
                    isAddingExpense = false,
                    name = "",
                    description = "",
                    amount = 0.0
                ) }
            }
            is ExpenseInsert.SetAmount -> {
                _expenseState.update { it.copy(
                    amount = -1 * event.amount
                ) }
            }
            is ExpenseInsert.SetCategory -> {
                _expenseState.update { it.copy(
                    categoryID = screenType
                ) }
            }
            is ExpenseInsert.SetDescription -> {
                _expenseState.update { it.copy(description = event.description) }
            }
            is ExpenseInsert.SetName -> {
                _expenseState.update { it.copy(name = event.name) }
            }
            is ExpenseInsert.SortExpenses -> {
                _sortExpenseOrder.value = SortOrder.ID
            }
        }
    }

    // Acquisitions Category view model
    private val _sortAcquisitionCategoryOrder = MutableStateFlow(SortOrder.ID)
    private val _acquisitionCategoryTransactions = _sortAcquisitionCategoryOrder
        .flatMapLatest {sortAcquisitionCategoryOrder ->
            when(sortAcquisitionCategoryOrder){
                SortOrder.ID -> dao.getAllAcquisitionCategory()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _acquisitionCategoryState = MutableStateFlow(AcquisitionsCategoryState())
    val acquisitionCategoryState = combine(_acquisitionCategoryState, _sortAcquisitionCategoryOrder, _acquisitionCategoryTransactions){state, sortOrder, transaction ->
        state.copy(
            acquisitionCategory = transaction,
            sortAcquisitions = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AcquisitionsCategoryState())
    fun acquisitionsCategoryEvent(event: AcquisitionsCategoryInsert)
    {
        when(event)
        {
            AcquisitionsCategoryInsert.SaveAcquisition -> {
                val name = acquisitionCategoryState.value.name
                val description = acquisitionCategoryState.value.description
                if(name.equals(""))
                {
                    return
                }
                val acquisitionCategory = AcquisitionCategory(
                    name = name,
                    description = description
                )
                viewModelScope.launch {
                    dao.insertAcquisitionCat(acquisitionCategory)
                }
                _acquisitionCategoryState.update{it.copy(
                    isAddingAcquisitionCategory = false,
                    description = "",
                    name = ""
                )}
            }
            is AcquisitionsCategoryInsert.SetDescription -> {
                _acquisitionCategoryState.update { it.copy(description = event.description) }
            }
            is AcquisitionsCategoryInsert.SetName -> {
                _acquisitionCategoryState.update { it.copy(name = event.name) }
            }
            is AcquisitionsCategoryInsert.SortAcquisitions -> {
                _sortAcquisitionCategoryOrder.value = SortOrder.ID
            }
        }
    }

    // Assets view model
    private val _sortAssetsOrder = MutableStateFlow(SortOrder.ID)
    private val _assetsTransactions = _sortAssetsOrder
        .flatMapLatest {sortAssetsOrder ->
            when(sortAssetsOrder){
                SortOrder.ID -> dao.getAllAssets()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    private val _assetsState = MutableStateFlow(AssetsState())
    val assetsState = combine(_assetsState, _sortAssetsOrder, _assetsTransactions){state, sortOrder, transaction ->
        state.copy(
            assets = transaction,
            sortAssets = sortOrder
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AssetsState())
//    fun assetsEvent(event: AssetsInsert, screenType: Int)
//    {
//        when(event)
//        {
//            is AssetsInsert.DeleteAsset -> {
//                viewModelScope.launch {
//                dao.deleteAsset(event.assets)}
//                _assetsState.update {it.copy(
//                    isAddingAsset = false
//                )
//                }}
//            AssetsInsert.SaveAsset -> {
//                val name = _assetsState.value.name
//                val description = _assetsState.value.description
//                val amount = _assetsState.value.worth
//                val date = _assetsState.value.divestmentDate
//                if(name.equals(""))
//                {
//                    return
//                }
//                val asset = Assets(
//                    assetsName = name,
//                    description = description,
//                    worth = amount,
//                    divestmentDate = date,
//                    typeID = screenType,
//                    acquisitionCatID = 1,
//                    acquiredDate =
//                )
//                viewModelScope.launch {  }
//            }
//            is AssetsInsert.SetAcquiredDate -> TODO()
//            is AssetsInsert.SetAcquisitionCategory -> TODO()
//            is AssetsInsert.SetDescription -> TODO()
//            is AssetsInsert.SetDivestmentDate -> TODO()
//            is AssetsInsert.SetName -> TODO()
//            is AssetsInsert.SetType -> TODO()
//            is AssetsInsert.SetWorth -> TODO()
//            is AssetsInsert.SortAssets -> TODO()
      //  }
    //}
}