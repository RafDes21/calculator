package com.rafdev.calculadora.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafdev.calculadora.screens.main.MainScreen
import com.rafdev.calculadora.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun Navigation(modifier: Modifier) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoot.SplashScreen.route) {
        composable(ScreenRoot.SplashScreen.route) {
            LaunchedEffect(key1 = null) {
                delay(2000)
                navController.popBackStack()
                navController.navigate(ScreenRoot.MainScreen.route)
            }
            SplashScreen()
        }
        composable(ScreenRoot.MainScreen.route) {
            MainScreen(modifier)
        }
    }

}

sealed class ScreenRoot(val route: String) {
    object SplashScreen : ScreenRoot("splash")
    object MainScreen : ScreenRoot("main")
    object CalculatorScreen : ScreenRoot("calculator_screen")
    object HistoryScreen : ScreenRoot("history_screen")
}