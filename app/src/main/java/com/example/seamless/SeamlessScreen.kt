package com.example.seamless

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.seamless.ui.screens.BusinessScreen
import com.example.seamless.ui.screens.PersonalScreen
import com.example.seamless.ui.screens.StartScreen

enum class SeamlessScreen {
    Start,
    Personal,
    Business
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
                    currentScreen = "Personal" // When user click Personal button, currentScreen shows "Personal"
                },
                onBusinessButtonClicked = {
                    navController.navigate(SeamlessScreen.Business.name)
                    currentScreen = "Business"
                },
                modifier = Modifier)
        }

        composable(route = SeamlessScreen.Personal.name) {
            PersonalScreen(
                modifier = Modifier,
                onHomeButtonClicked = { goHome(navController = navController)
                    currentScreen = "Start"}
            )
        }

        composable(route = SeamlessScreen.Business.name) {
            BusinessScreen(
                modifier = Modifier,
                onHomeButtonClicked = { goHome(navController = navController)
                    currentScreen = "Start"}
            )
        }
    }
}

private fun goHome(
    navController: NavHostController
) {
    navController.popBackStack(SeamlessScreen.Start.name, inclusive = false)
}