package com.example.seamless

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seamless.ui.screens.AddCategories
import com.example.seamless.ui.screens.BusinessScreen
import com.example.seamless.ui.screens.PersonalScreen
import com.example.seamless.ui.screens.StartScreen

enum class SeamlessScreen {
    Start,
    Personal,
    Business,
    BusinessAdd,
    PersonalAdd,
    BusinessIncome,
    BusinessExpenses,
    PersonalIncome,
    PersonalExpenses
}

@Composable
fun SeamlessApp(
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
                    currentScreen = 0}
            )
        }

        composable(route = SeamlessScreen.BusinessAdd.name){
            AddCategories(
                modifier = Modifier,
                onConfirmButtonClicked = {
                    /* TODO: Implement Add Business Income/Expense*/
                },
                onCancelButtonClicked = {
                    navigateUp(navController)
                },
                databaseObject = { /* TODO: Database Object Passed Here */}
            )
        }

        composable(route = SeamlessScreen.PersonalAdd.name){
            AddCategories(
                modifier = Modifier,
                onConfirmButtonClicked = {
                    /* TODO: Implement Add Business Income/Expense*/
                },
                onCancelButtonClicked = {
                    navigateUp(navController)
                },
                databaseObject = { /* TODO: Database Object Passed Here */}
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