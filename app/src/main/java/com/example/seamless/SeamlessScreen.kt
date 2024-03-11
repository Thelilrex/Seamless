package com.example.seamless

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
                },
                onBusinessButtonClicked = {
                    navController.navigate(SeamlessScreen.Business.name)
                },
                modifier = Modifier)
        }

        composable(route = SeamlessScreen.Personal.name) {
            PersonalScreen(modifier = Modifier)
        }

        composable(route = SeamlessScreen.Business.name) {
            BusinessScreen(modifier = Modifier)
        }
    }
}