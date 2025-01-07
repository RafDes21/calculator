package com.rafdev.calculadora.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rafdev.calculadora.components.BottomNavigationBar
import com.rafdev.calculadora.screens.calculator.CalculatorScreen
import com.rafdev.calculadora.screens.history.HistoryScreen
import com.rafdev.calculadora.screens.navigation.ScreenRoot
import com.rafdev.calculadora.screens.splash.SplashScreen
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = ScreenRoot.CalculatorScreen.route,
            modifier = Modifier.padding(paddingValues = innerPadding)) {
            composable(ScreenRoot.CalculatorScreen.route) {
                CalculatorScreen()
            }
            composable(ScreenRoot.HistoryScreen.route) {
                HistoryScreen()
            }

        }
    }

}


//@Preview(showSystemUi = true)
//@Composable
//fun MainScreenPreview(modifier: Modifier = Modifier) {
//    MainScreen()
//}
