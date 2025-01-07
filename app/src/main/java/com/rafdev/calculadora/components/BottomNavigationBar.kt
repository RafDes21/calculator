package com.rafdev.calculadora.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rafdev.calculadora.R
import com.rafdev.calculadora.screens.navigation.ScreenRoot

@Composable
fun BottomNavigationBar(navController: NavController) {

    val selectedItem = remember { mutableStateOf(ScreenRoot.CalculatorScreen.route) }

    NavigationBar(
        modifier = Modifier.height(100.dp),
        containerColor = Color.Transparent,
        contentColor = Color.Black
    ) {
        NavigationBarItem(
            modifier = Modifier,
            selected = false,
            onClick = {
                navController.navigate(ScreenRoot.CalculatorScreen.route)
                selectedItem.value = ScreenRoot.CalculatorScreen.route
            },
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.ic_calculator),
                    contentDescription = "Calculator",
                    tint = if (selectedItem.value == ScreenRoot.CalculatorScreen.route) Color.Blue else Color.Gray
                )
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {
                navController.navigate(ScreenRoot.HistoryScreen.route)
                selectedItem.value = ScreenRoot.HistoryScreen.route
            },
            icon = {
                Icon(
                    modifier = Modifier.size(35.dp),
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = "History",
                    tint = if (selectedItem.value == ScreenRoot.HistoryScreen.route) Color.Blue else Color.Gray
                )
            }
        )
    }
}