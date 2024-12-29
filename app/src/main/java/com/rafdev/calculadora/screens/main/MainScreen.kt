package com.rafdev.calculadora.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafdev.calculadora.ui.theme.CalculatorPalette

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
        modifier
            .fillMaxSize()
            .background(CalculatorPalette.lightBlue)
    ) {
        Text(text = "welcome")
    }
}

