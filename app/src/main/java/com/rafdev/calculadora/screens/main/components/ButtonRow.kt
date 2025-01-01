package com.rafdev.calculadora.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rafdev.calculadora.R
import com.rafdev.calculadora.components.ItemButton
import com.rafdev.calculadora.domain.model.ButtonModel
import com.rafdev.calculadora.ui.theme.CalculatorPalette
import com.rafdev.calculadora.util.CalculatorAction

@Composable
fun ButtonRow(
    buttons: List<ButtonModel>,
    onButtonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        buttons.forEach { btn ->
            when (btn.symbol) {
                CalculatorAction.EQUALS -> {
                    ItemButton(
                        symbol = btn.symbol,
                        symColor = btn.color,
                        modifier = Modifier
                            .background(CalculatorPalette.lightGolden)
                            .height(82.dp)
                            .weight(1f)
                    ) {
                        onButtonClick(btn.symbol)
                    }
                }

                CalculatorAction.BACKSPACE -> {
                    ItemButton(
                        symbol = "",
                        symColor = btn.color,
                        onClick = { onButtonClick(btn.symbol) },
                        modifier = Modifier
                            .weight(1f)
                            .size(82.dp),
                        iconResourceId = R.drawable.ic_backspace
                    )
                }

                else -> {
                    ItemButton(
                        symbol = btn.symbol,
                        symColor = btn.color,
                        modifier = Modifier
                            .weight(1f)
                            .size(82.dp)
                    ) {
                        onButtonClick(btn.symbol)
                    }
                }
            }
        }
    }
}