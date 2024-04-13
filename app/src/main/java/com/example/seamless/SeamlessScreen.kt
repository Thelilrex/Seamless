package com.example.seamless

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seamless.database.AppDatabase
import com.example.seamless.database.Expenses
import com.example.seamless.database.Income
import com.example.seamless.ui.screens.AddCategories
import com.example.seamless.ui.screens.AddExpenseCategories
import com.example.seamless.ui.screens.BusinessScreen
import com.example.seamless.ui.screens.PersonalIncomesScreen
import com.example.seamless.ui.screens.PersonalScreen
import com.example.seamless.ui.screens.PersonalSpendsScreen
import com.example.seamless.ui.screens.StartScreen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking

enum class SeamlessScreen {
    Start,
    Personal,
    Business,
    BusinessAdd,
    PersonalAdd,
    PersonalExpenseAdd,
    BusinessIncome,
    BusinessExpenses,
    PersonalIncome,
    PersonalExpenses,
}

@Composable
fun SeamlessApp(context: Context
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SeamlessScreen.Start.name) {
        composable(route = SeamlessScreen.Start.name) {
            StartScreen(
                onPersonalButtonClicked = {
                    navController.navigate(SeamlessScreen.Personal.name)
                    currentScreen = 1 // When user click Personal button, currentScreen = 1 for Personal
                },
                onBusinessButtonClicked = {
                    navController.navigate(SeamlessScreen.Business.name)
                    currentScreen = 2
                },
                modifier = Modifier)
        }

        composable(route = SeamlessScreen.Personal.name) {
            PersonalScreen(
                modifier = Modifier,
                onHomeButtonClicked = { goHome(navController = navController)
                    currentScreen = 0},
                onIncomeButtonClicked = {
                    navController.navigate(SeamlessScreen.PersonalIncome.name)
                },
                onSpendsButtonClicked = {
                    navController.navigate(SeamlessScreen.PersonalExpenses.name)
                }
            )
        }

        composable(route = SeamlessScreen.Business.name) {
            BusinessScreen(
                modifier = Modifier,
                onHomeButtonClicked = { goHome(navController = navController)
                    currentScreen = 0},
                onIncomeButtonClicked = {
                    navController.navigate(SeamlessScreen.BusinessIncome.name)
                },
                onSpendsButtonClicked = {
                    navController.navigate(SeamlessScreen.BusinessExpenses.name)
                }
            )
        }

        composable(route = SeamlessScreen.PersonalIncome.name){
            PersonalIncomesScreen(
                incomeToList = {incomeFlowToList(context, currentScreen)},
                onDialogueConfirmButtonClicked = {/*TODO: Add to Personal Income*/},
                onDeleteButtonClicked = {/*TODO: Delete from Personal Income*/},
                onAddButtonClicked = {navController.navigate(SeamlessScreen.PersonalAdd.name)},
                context = context
                )
        }

        composable(route = SeamlessScreen.PersonalExpenses.name){
            PersonalSpendsScreen(
                onDialogueConfirmButtonClicked = {/*TODO: Add to Personal Expenses*/},
                onDeleteButtonClicked = {/*TODO: Delete from Personal Expenses*/},
                onAddExpenseButtonClicked = {navController.navigate(SeamlessScreen.PersonalExpenseAdd.name)},
                context = context,
                expenseToList = {expenseFlowToList(context, currentScreen)}
            )
        }

        composable(route = SeamlessScreen.BusinessIncome.name){
            PersonalIncomesScreen(
                onDialogueConfirmButtonClicked = {/*TODO: Add to Business Income*/},
                onDeleteButtonClicked = {/*TODO: Delete from Business Income*/},
                context = context,
                incomeToList = {incomeFlowToList(context, currentScreen)}
                )
        }

        composable(route = SeamlessScreen.BusinessExpenses.name){
            PersonalSpendsScreen(
                onDialogueConfirmButtonClicked = {/*TODO: Add to Business Expense*/},
                onDeleteButtonClicked = {/*TODO: Delete from Business Expense*/},
                context = context,
                expenseToList = {expenseFlowToList(context, currentScreen)}
            )
        }

        //NOTE: Add Categories functions never get called and can't be navigated to because there's no buttons for them in UI!?
        composable(route = SeamlessScreen.BusinessAdd.name){
            AddCategories(
                modifier = Modifier,
                onConfirmButtonClicked = {
                    /* TODO: Implement Add Business Income/Expense*/
                },
                onCancelButtonClicked = {
                    navigateUp(navController)
                },
                showDialog = remember { mutableStateOf(false) },
                context = context
            )
        }

        composable(route = SeamlessScreen.PersonalAdd.name){
            AddCategories(
                modifier = Modifier,
                onConfirmButtonClicked = {
                    /* TODO: Implement Add Business Income/Expense*/
                },
                onCancelButtonClicked = {
                    navController.navigate(SeamlessScreen.PersonalIncome.name)
                },
                showDialog = remember { mutableStateOf(false) },
                context = context
            )
        }

        composable(route = SeamlessScreen.PersonalExpenseAdd.name){
            AddExpenseCategories(
                modifier = Modifier,
                onConfirmButtonClicked = {
                    /* TODO: Implement Add Personal Expense*/
                },
                onCancelButtonClicked = {
                    navController.navigate(SeamlessScreen.PersonalExpenses.name)
                },
                showDialog = remember { mutableStateOf(false) },
                context = context
            )
        }
    }
}

private fun goHome(
    navController: NavHostController
) {
    navController.popBackStack(SeamlessScreen.Start.name, inclusive = false)
}

private fun navigateUp(
    navController: NavHostController
){
    /* TODO: implement back navigation */
}

private fun incomeFlowToList(context: Context, typeID: Int): List<Income>
{
    val dao = AppDatabase.getDatabase(context).appDao()
    val flowIncome: Flow<List<Income>>
    runBlocking {flowIncome = dao.getIncomeByType(typeID)}
    return runBlocking {
        flowIncome
            .flatMapConcat { it.asFlow() }
            .toList()
    }
}

private fun expenseFlowToList(context: Context, typeID: Int): List<Expenses>
{
    val dao = AppDatabase.getDatabase(context).appDao()
    val flowExpense: Flow<List<Expenses>>
    runBlocking {flowExpense = dao.getExpensesByType(typeID)}
    return runBlocking {
        flowExpense
            .flatMapConcat { it.asFlow() }
            .toList()
    }
}