package com.example.seamless.ui.database.transactions

import androidx.lifecycle.ViewModel
import com.example.seamless.ui.database.AppDao
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
class TransactionViewModel (private val dao: AppDao): ViewModel()
{

}