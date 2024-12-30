package com.rafdev.calculadora.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rafdev.calculadora.components.ItemButton
import com.rafdev.calculadora.domain.buttonData.ButtonData
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.ui.theme.CalculatorPalette

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val rows = ButtonData.buttonRows

    Box(
        modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        CalculatorPalette.lightBlue,
                        CalculatorPalette.darkBlue,
                    )
                )
            )
    ) {
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

            rows.forEach { row ->
                ButtonRow(row)
            }
        }
    }
}

@Composable
fun ButtonRow(buttons: List<ButtonModel>, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        buttons.forEach { btn ->
            if (btn.symbol == "=") {
                ItemButton(
                    symbol = btn.symbol,
                    symColor = btn.color,
                    modifier = Modifier
                        .background(CalculatorPalette.golden)
                        .height(80.dp)
                        .weight(2f)
                ) {
                }
            } else {
                ItemButton(
                    symbol = btn.symbol,
                    symColor = btn.color,
                    modifier = Modifier
                        .weight(1f)
                        .size(80.dp)
                ) {
                }
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun MainScreenPreview(modifier: Modifier = Modifier) {
    MainScreen()
}
