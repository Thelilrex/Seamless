package com.example.seamless

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                
                modifier = Modifier)
        }

        composable(route = SeamlessScreen.Personal.name) {

        }

        composable(route = SeamlessScreen.Business.name) {

        }
    }
}