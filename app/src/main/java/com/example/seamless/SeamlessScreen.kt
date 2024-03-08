package com.example.seamless

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

enum class SeamlessScreen {
    Start,
    Personal,
    Business
}

@Composable
fun SeamlessApp(
    navController: NavController = rememberNavController()
){

}