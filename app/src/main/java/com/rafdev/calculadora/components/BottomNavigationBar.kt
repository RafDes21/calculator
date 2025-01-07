package com.rafdev.calculadora.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.rafdev.calculadora.R
import com.rafdev.calculadora.screens.navigation.ScreenRoot

@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar {
        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ScreenRoot.CalculatorScreen.route) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_calculator),
                    contentDescription = "Calculadora"
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = { navController.navigate(ScreenRoot.HistoryScreen.route) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = "Historial"
                )
            }
        )
    }
}